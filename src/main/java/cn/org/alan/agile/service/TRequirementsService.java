package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TRequirements;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
import cn.org.alan.agile.model.form.requirement.ReqUpdateState;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author alan
* @description 针对表【T_Requirements】的数据库操作Service
* @createDate 2024-07-03 07:59:51
*/
public interface TRequirementsService extends IService<TRequirements> {

    Result saveReq(ReqSaveForm reqSaveForm);

    Result getReq(Integer pageNum, Integer pageSize, Integer type,Integer itemId);

    Result updateReqState(ReqUpdateState reqUpdateState);

    Result<String> delReq(Long reqId);
}
