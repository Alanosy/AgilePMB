package cn.org.alan.agile.controller;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
import cn.org.alan.agile.model.form.requirement.ReqUpdateState;
import cn.org.alan.agile.service.TRequirementsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    /**
     * 添加需求
     * @param reqSaveForm
     * @return
     */
    @PostMapping
    public Result<String> saveReq(@RequestBody ReqSaveForm reqSaveForm){
        Result  result = tRequirementsService.saveReq(reqSaveForm);
        return result;
    }

    /**
     * 分页查询需求列表
     * @param pageNum
     * @param pageSize
     * @param type
     * @param itemId
     * @return
     */

    @GetMapping
    public Result<String> getReq(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "type", required = false) Integer type,
                                 @RequestParam(value = "itemId", required = false) Integer itemId){
        Result  result = tRequirementsService.getReq(pageNum,pageSize,type,itemId);
        return result;
    }

    /**
     * 更新状态
     * @param reqUpdateState
     * @return
     */
    @PutMapping("/updatestate")
    public Result<String> updateReqState(@RequestBody ReqUpdateState reqUpdateState){
        Result  result = tRequirementsService.updateReqState(reqUpdateState);
        return result;
    }

    /**
     * 删除需求
     * @param reqId
     * @return
     */
    @DeleteMapping("/{reqId}")
    public Result<String> delReq(@PathVariable("reqId") Long reqId) {
        return tRequirementsService.delReq(reqId);
    }
}

