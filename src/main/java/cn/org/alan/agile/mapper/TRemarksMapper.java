package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TProjects;
import cn.org.alan.agile.model.entity.TRemarks;
import cn.org.alan.agile.model.vo.project.RemarkGetVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/25 9:41 PM
 */
public interface TRemarksMapper extends BaseMapper<TRemarks> {
    List<RemarkGetVo> getRemark(Long itemId);
}
