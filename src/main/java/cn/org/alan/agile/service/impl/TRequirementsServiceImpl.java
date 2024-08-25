package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.TRequirementsConverter;
import cn.org.alan.agile.model.form.requirement.ReqSaveForm;
import cn.org.alan.agile.model.form.requirement.ReqUpdateState;
import cn.org.alan.agile.model.vo.requirement.ReqGetVo;
import cn.org.alan.agile.util.SecretUtils;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TRequirements;
import cn.org.alan.agile.service.TRequirementsService;
import cn.org.alan.agile.mapper.TRequirementsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @Resource
    private TRequirementsConverter tRequirementsConverter;
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

    @Override
    public Result getReq(Integer pageNum, Integer pageSize, Integer type,Integer itemId) {

        // 创建Page对象
        Page<TRequirements> page = new Page<>(pageNum, pageSize);
        // 开始查询
        // LambdaQueryWrapper<TRequirements> ReqQuery = new LambdaQueryWrapper<>();
        // ReqQuery.like(StringUtils.isNotBlank(name), TRequirements::getName, name);
        // if (itemId != null && !itemId.equals("")) {
        //     ReqQuery.eq(TRequirements::getItemid, itemId);
        // }
        Page<ReqGetVo> ReqPage = tRequirementsMapper.getReq(page,itemId,type, SecurityUtil.getUserId(),SecurityUtil.getTeamId());
        // 实体转换
        // Page<ReqGetVo> ReqVo = tRequirementsConverter.pageTopPV(ReqPage);
        return Result.success("查询成功", ReqPage);
    }

    @Override
    public Result updateReqState(ReqUpdateState reqUpdateState) {
        LambdaUpdateWrapper<TRequirements> tRequirementsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        tRequirementsLambdaUpdateWrapper.eq(TRequirements::getId,reqUpdateState.getId())
                .set(TRequirements::getState,reqUpdateState.getState());
        int update = tRequirementsMapper.update(tRequirementsLambdaUpdateWrapper);
        if(update>0){
            return Result.success("保存成功");
        }
        return Result.failed("保存失败");
    }

    @Override
    public Result<String> delReq(Long reqId) {
        LambdaQueryWrapper<TRequirements> tRequirementsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tRequirementsLambdaQueryWrapper.eq(TRequirements::getId,reqId);
        int deleterow = tRequirementsMapper.delete(tRequirementsLambdaQueryWrapper);
        if(deleterow>0){
            return Result.success("删除成功");
        }
        return Result.failed("删除失败");

    }
}




