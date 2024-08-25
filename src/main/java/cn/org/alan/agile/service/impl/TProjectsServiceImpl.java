package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.mapper.TFilesMapper;
import cn.org.alan.agile.mapper.TRemarksMapper;
import cn.org.alan.agile.model.entity.TFiles;
import cn.org.alan.agile.model.entity.TRemarks;
import cn.org.alan.agile.model.form.project.ItemContentUpdateForm;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.form.project.RemarkSaveForm;
import cn.org.alan.agile.model.vo.project.*;
import cn.org.alan.agile.util.AliOSSUtil;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.service.TProjectsService;
import cn.org.alan.agile.mapper.TProjectsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
* @author alan
* @description 针对表【T_Projects】的数据库操作Service实现
* @createDate 2024-07-03 07:59:50
*/
@Service
public class TProjectsServiceImpl extends ServiceImpl<TProjectsMapper, TProjects>
    implements TProjectsService{
    @Resource
    private TProjectsMapper tProjectsMapper;
    @Resource
    private TRemarksMapper tRemarksMapper;
    @Resource
    private AliOSSUtil aliOSSUtil;
    @Resource
    private TFilesMapper tFilesMapper;

    @Override
    public Result<IPage<ProjectPageVo>> getItemPage(Integer pageNum, Integer pageSize, String itemName, Integer type) {
        IPage<ProjectPageVo> page = new Page(pageNum, pageSize);
        IPage<ProjectPageVo> iPage = tProjectsMapper.selectProject(page,itemName, SecurityUtil.getTeamId(),type,SecurityUtil.getUserId());
        return Result.success("查询成功",iPage);
    }

    @Override
    public Result saveItem(ProjectSaveForm projectSaveForm) {
        TProjects tProjects = new TProjects();
        tProjects.setName(projectSaveForm.getName());
        tProjects.setEnddate(projectSaveForm.getEnddate());
        tProjects.setStartdate(projectSaveForm.getStartdate());
        tProjects.setState(projectSaveForm.getState());
        tProjects.setUserid(projectSaveForm.getUserid());
        tProjects.setTeamid(SecurityUtil.getTeamId());
        int insert = tProjectsMapper.insert(tProjects);
        return Result.success("保存成功",insert);
    }

    @Override
    public List<fetchProjectsVo> fetchProjects() {
        List<fetchProjectsVo> projectsVoList = tProjectsMapper.fetchProjects();
        return projectsVoList;
    }

    @Override
    public Result getOverviewItem(Long itemId) {
        OverviewItemGetVo result = tProjectsMapper.getOverviewItem(itemId);
        Integer reqPercent ;
        if(result.getReqNum()!=0){
            reqPercent = (result.getReqfNum()/result.getReqNum())*100;
        }else {
            reqPercent = 0;
        }
        result.setReqPercent(reqPercent);

        Integer issuePercent ;
        if(result.getIssueNum()!=0){
            issuePercent = (result.getIssuefNum()/result.getIssueNum())*100;
        }else {
            issuePercent = 0;
        }
        result.setIssuePercent(issuePercent);
        Integer taskPercent ;
        if(result.getTaskNum()!=0){
            taskPercent = (result.getTaskfNum()/result.getTaskNum())*100;
        }else {
            taskPercent = 0;
        }
        result.setTaskPercent(taskPercent);
        return Result.success("请求成功",result);
    }

    @Override
    public Result getItemContent(Long itemId) {
        ItemContentGetVo result = tProjectsMapper.getItemContent(itemId);
        return Result.success("请求成功",result);
    }

    @Override
    public Result updateItemContent(ItemContentUpdateForm itemContentUpdateForm) {
        LambdaUpdateWrapper<TProjects> tProjectsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        tProjectsLambdaUpdateWrapper.eq(TProjects::getId,itemContentUpdateForm.getItemId())
                .set(TProjects::getContent,itemContentUpdateForm.getContent());
        int update = tProjectsMapper.update(tProjectsLambdaUpdateWrapper);
        if(update>0){
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }

    @Override
    public Result saveRemark(RemarkSaveForm remarkSaveForm) {
        TRemarks tRemarks = new TRemarks();
        tRemarks.setItemid(remarkSaveForm.getItemId());
        tRemarks.setContent(remarkSaveForm.getContent());
        tRemarks.setUserid(SecurityUtil.getUserId());
        int insert = tRemarksMapper.insert(tRemarks);
        if(insert>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result getRemark(Long itemId) {
        List<RemarkGetVo> result = tRemarksMapper.getRemark(itemId);
        return Result.success("请求成功",result);
    }

    @Override
    @Transactional
    public Result<String> uploadFile(MultipartFile file, Long itemId) throws IOException {

        // 避免文件覆盖
        String fileName = file.getOriginalFilename();


        String url = aliOSSUtil.upload(file);

        if (StringUtils.isBlank(url)) {
            return Result.failed("图片上传失败");
        }
        TFiles tFiles = new TFiles();
        tFiles.setUrl(url);
        tFiles.setFilename(fileName);
        tFiles.setUserid(SecurityUtil.getUserId());
        tFiles.setItemid(itemId);
        int insert = tFilesMapper.insert(tFiles);
        if(insert>0){
            return Result.success("图片上传成功", url);

        }
        return Result.success("图片上传失败");

    }

    @Override
    public Result getFileList(Long itemId) {
        List<FileListGetVo> result = tFilesMapper.getFileList(itemId);
        return Result.success("请求成功",result);
    }
}




