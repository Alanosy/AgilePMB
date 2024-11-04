package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TRequirements;
import cn.org.alan.agile.model.form.requirement.ReqUpdateForm;
import cn.org.alan.agile.model.vo.requirement.ReqGetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author alan
* @description 针对表【T_Requirements】的数据库操作Mapper
* @createDate 2024-07-03 07:59:51
* @Entity cn.org.alan.exam.model/entity.TRequirements
*/
public interface TRequirementsMapper extends BaseMapper<TRequirements> {

    Page<ReqGetVo> getReq(Page<TRequirements> page, Integer itemId, Integer type, Long userId, Long teamId);

    int updateReq(ReqUpdateForm reqUpdateForm);
}




