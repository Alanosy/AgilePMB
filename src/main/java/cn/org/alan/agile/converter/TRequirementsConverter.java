package cn.org.alan.agile.converter;

import cn.org.alan.agile.model.entity.TRequirements;
import cn.org.alan.agile.model.vo.requirement.ReqGetVo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Component;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/20 12:48 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface TRequirementsConverter {

    ReqGetVo entityToEV(TRequirements r);

    Page<ReqGetVo> pageTopPV(Page<TRequirements> p);
}
