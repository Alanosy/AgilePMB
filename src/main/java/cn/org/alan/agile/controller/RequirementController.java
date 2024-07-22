package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
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
@RequestMapping("/api/requirements")
public class RequirementController {
    @Resource
    private TRequirementsService tRequirementsService;
    @PostMapping
    public Result<String> saveReq(@RequestBody ReqSaveForm reqSaveForm){
        Result  result = tRequirementsService.saveReq(reqSaveForm);
        return result;
    }
}
