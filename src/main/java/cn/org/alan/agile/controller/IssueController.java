package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.issue.IssueSaveForm;
import cn.org.alan.agile.model.form.issue.IssueUpdateState;
import cn.org.alan.agile.model.form.issue.UpdateIssueForm;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
import cn.org.alan.agile.model.form.requirement.ReqUpdateState;
import cn.org.alan.agile.service.TIssuesService;
import cn.org.alan.agile.service.TRequirementsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Alan
 * @Version
 * @Date 2024/7/3 2:31 PM
 */
@RestController
@RequestMapping("/api/issues")
public class IssueController {
    @Resource
    private TIssuesService tIssuesService;

    /**
     * 添加问题
     * @param issueSaveForm
     * @return
     */
    @PostMapping
    public Result<String> saveIssue(@RequestBody IssueSaveForm issueSaveForm){
        Result  result = tIssuesService.saveIssue(issueSaveForm);
        return result;
    }

    /**
     * 分页查询问题列表
     * @param pageNum
     * @param pageSize
     * @param itemId
     * @param issueType
     * @param type
     * @return
     */
    @GetMapping
    public Result<String> getIssue(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "itemId", required = false) Integer itemId,
                                @RequestParam(value = "issueType", required = false) String issueType,
                               @RequestParam(value = "type",required = false) String type){
        Result  result = tIssuesService.getIssue(pageNum,pageSize,itemId,issueType,type);
        return result;
    }

    /**
     * 修改表格中问题的状态
     * @param issueUpdateState
     * @return
     */
    @PutMapping("/updatestate")
    public Result<String> updateIssueState(@RequestBody IssueUpdateState issueUpdateState){
        Result  result = tIssuesService.updateIssueState(issueUpdateState);
        return result;
    }

    /**
     * 删除问题
     * @param issueId
     * @return
     */
    @DeleteMapping("/{issueId}")
    public Result<String> delIssue(@PathVariable("issueId") Long issueId) {
        return tIssuesService.delIssue(issueId);
    }

    @PutMapping
    public Result updateIssue(@RequestBody UpdateIssueForm updateIssueForm){
        Result  result = tIssuesService.updateIssue(updateIssueForm);
        return result;
    }
}
