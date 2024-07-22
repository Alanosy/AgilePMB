package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.project.ProjectSaveForm;
import cn.org.alan.agile.model.vo.project.ProjectPageVo;
import cn.org.alan.agile.service.TProjectsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public Result<IPage<ProjectPageVo>> getItemPage(@RequestParam(value = "pageNum",required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "itemName",required = false) String itemName){
        Result itemPage = tProjectsService.getItemPage(pageNum,pageSize,itemName);
        return itemPage;
    }

    @PostMapping
    public Result<String> saveItem(@RequestBody ProjectSaveForm projectSaveForm){
        Result item = tProjectsService.saveItem(projectSaveForm);
        return item;
    }
}
