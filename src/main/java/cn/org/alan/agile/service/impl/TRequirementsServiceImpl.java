package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TRequirements;
import cn.org.alan.agile.service.TRequirementsService;
import cn.org.alan.agile.mapper.TRequirementsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author alan
* @description 针对表【T_Requirements】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TRequirementsServiceImpl extends ServiceImpl<TRequirementsMapper, TRequirements>
    implements TRequirementsService{

    @Resource
    private TRequirementsMapper tRequirementsMapper;
    @Override
    public Result saveReq(ReqSaveForm reqSaveForm) {
        TRequirements tRequirements = new TRequirements();
        tRequirements.setContent(reqSaveForm.getContent());
        tRequirements.setName(reqSaveForm.getName());
        tRequirements.setPriority(reqSaveForm.getPriority());
        tRequirements.setUserid(reqSaveForm.getUserid());
        int insert = tRequirementsMapper.insert(tRequirements);
        if(insert>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }
}




