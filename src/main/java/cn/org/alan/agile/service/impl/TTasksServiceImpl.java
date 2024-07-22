package cn.org.alan.agile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TTasks;
import cn.org.alan.agile.service.TTasksService;
import cn.org.alan.agile.mapper.TTasksMapper;
import org.springframework.stereotype.Service;

/**
* @author alan
* @description 针对表【T_Tasks】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TTasksServiceImpl extends ServiceImpl<TTasksMapper, TTasks>
    implements TTasksService{

}




