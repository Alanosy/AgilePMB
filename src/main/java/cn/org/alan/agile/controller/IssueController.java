package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.issue.IssueSaveForm;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
import cn.org.alan.agile.service.TIssuesService;
import cn.org.alan.agile.service.TRequirementsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping
    public Result<String> saveIssue(@RequestBody IssueSaveForm issueSaveForm){
        Result  result = tIssuesService.saveIssue(issueSaveForm);
        return result;
    }
}
