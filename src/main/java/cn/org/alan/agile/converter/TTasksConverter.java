package cn.org.alan.agile.converter;

import cn.org.alan.agile.model.entity.TTasks;
import cn.org.alan.agile.model.vo.task.TaskGetVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/20 12:48 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface TTasksConverter {

    TaskGetVo entityToEV(TTasks t);

    Page<TaskGetVo> pageTopPV(Page<TTasks> t);
}
