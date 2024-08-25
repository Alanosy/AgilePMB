package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.project.ItemContentUpdateForm;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.form.project.RemarkSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import cn.org.alan.agile.model.vo.project.fetchProjectsVo;
import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import cn.org.alan.agile.service.TProjectsService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 2:31 PM
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Resource
    private TProjectsService tProjectsService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param itemName
     * @return
     */
    @GetMapping
    public Result<IPage<ProjectPageVo>> getItemPage(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "itemName",required = false) String itemName,
                                     @RequestParam(value = "type", required = false) Integer type){
        Result itemPage = tProjectsService.getItemPage(pageNum,pageSize,itemName,type);
        return itemPage;
    }

    /**
     * 添加项目
     * @param projectSaveForm
     * @return
     */
    @PostMapping
    public Result<String> saveItem(@RequestBody ProjectSaveForm projectSaveForm){
        Result item = tProjectsService.saveItem(projectSaveForm);
        return item;
    }

    /**
     * 项目选择框
     * @return
     */
    @GetMapping("/fetchProjects")
    public Result<List<fetchProjectsVo>> fetchProjects(){
        List<fetchProjectsVo> projectsList = tProjectsService.fetchProjects();
        return Result.success("请求成功",projectsList);
    }

    @GetMapping("/overview")
    public Result getOverviewItem(@RequestParam(value = "itemId",required = false) Long itemId){
        Result result = tProjectsService.getOverviewItem(itemId);
        return result;
    }
    @GetMapping("/itemContent")
    public Result getItemContent(@RequestParam(value = "itemId",required = false) Long itemId){
        Result result = tProjectsService.getItemContent(itemId);
        return result;
    }
    @PutMapping("/itemContent")
    public Result updateItemContent(@RequestBody ItemContentUpdateForm itemContentUpdateForm){
        Result result = tProjectsService.updateItemContent(itemContentUpdateForm);
        return result;
    }
    @PostMapping("/remark")
    public Result saveRemark(@RequestBody RemarkSaveForm remarkSaveForm){
        Result result = tProjectsService.saveRemark(remarkSaveForm);
        return result;
    }
    @GetMapping("/remark")
    public Result getRemark(@RequestParam(value = "itemId",required = false) Long itemId){
        Result result = tProjectsService.getRemark(itemId);
        return result;
    }
    /**
     * 上传附件
     * @param file 文件
     * @return 返回上传后的地址
     */
    @PostMapping("/uploadFile")
    public Result<String> uploadFile(@RequestPart("file") MultipartFile file,
                                     @RequestParam(value = "itemId",required = false) Long itemId) throws IOException {
        return tProjectsService.uploadFile(file,itemId);
    }
    @GetMapping("/file-list")
    public Result getFileList(@RequestParam(value = "itemId",required = false) Long itemId){
        Result result = tProjectsService.getFileList(itemId);
        return result;
    }
}
