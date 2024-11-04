package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.TIssuesConverter;
import cn.org.alan.agile.model.form.issue.IssueSaveForm;
import cn.org.alan.agile.model.form.issue.IssueUpdateState;
import cn.org.alan.agile.model.form.issue.UpdateIssueForm;
import cn.org.alan.agile.model.vo.issue.IssuesGetVo;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TIssues;
import cn.org.alan.agile.service.TIssuesService;
import cn.org.alan.agile.mapper.TIssuesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author alan
* @description 针对表【T_Issues】的数据库操作Service实现
* @createDate 2024-07-03 07:59:50
*/
@Service
public class TIssuesServiceImpl extends ServiceImpl<TIssuesMapper, TIssues> implements TIssuesService{

    @Resource
    private TIssuesMapper tIssuesMapper;
    @Resource
    private TIssuesConverter tIssuesConverter;

    @Override
    public Result saveIssue(IssueSaveForm issueSaveForm) {
        TIssues tIssues = new TIssues();
        tIssues.setName(issueSaveForm.getName());
        tIssues.setType(issueSaveForm.getType());
        tIssues.setItemid(issueSaveForm.getItemId());
        tIssues.setContent(issueSaveForm.getContent());
        tIssues.setPriority(issueSaveForm.getPriority());
        tIssues.setPrincipalid(issueSaveForm.getPrincipalId());
        tIssues.setState(issueSaveForm.getState());
        tIssues.setUserid(SecurityUtil.getUserId());
        tIssues.setEnddate(issueSaveForm.getEndDate());
        tIssues.setStartdate(issueSaveForm.getStartDate());
        tIssues.setTeamid(SecurityUtil.getTeamId());
        int insert = tIssuesMapper.insert(tIssues);
        if(insert>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result getIssue(Integer pageNum, Integer pageSize,Integer itemId,String issueType,String type) {
        // 创建Page对象
        Page<TIssues> page = new Page<>(pageNum, pageSize);
        // 开始查询
        Page<IssuesGetVo> IssuePage = tIssuesMapper.getIssue(page, itemId,issueType,type, SecurityUtil.getUserId(),SecurityUtil.getTeamId());
        return Result.success("查询成功", IssuePage);

    }

    @Override
    public Result updateIssueState(IssueUpdateState issueUpdateState) {
        LambdaUpdateWrapper<TIssues> tRequirementsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        tRequirementsLambdaUpdateWrapper.eq(TIssues::getId,issueUpdateState.getId())
                .set(TIssues::getState,issueUpdateState.getState());
        int update = tIssuesMapper.update(tRequirementsLambdaUpdateWrapper);
        if(update>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result<String> delIssue(Long issueId) {
        LambdaQueryWrapper<TIssues> tRequirementsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tRequirementsLambdaQueryWrapper.eq(TIssues::getId,issueId);
        int deleterow = tIssuesMapper.delete(tRequirementsLambdaQueryWrapper);
        if(deleterow>0){
            return Result.success("删除成功");
        }
        return Result.failed("删除失败");
    }

    @Override
    public Result updateIssue(Long issueId, UpdateIssueForm updateIssueForm) {
        updateIssueForm.setId(issueId);
        int row = tIssuesMapper.updateIssue(updateIssueForm);
        if(row>0){
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }
}




