package cn.org.alan.agile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TTaskUser;
import cn.org.alan.agile.service.TTaskUserService;
import cn.org.alan.agile.mapper.TTaskUserMapper;
import org.springframework.stereotype.Service;

/**
* @author alan
* @description 针对表【T_Task_User】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TTaskUserServiceImpl extends ServiceImpl<TTaskUserMapper, TTaskUser>
    implements TTaskUserService{

}




