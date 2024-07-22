package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.service.TUsersService;
import cn.org.alan.agile.mapper.TUsersMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author alan
* @description 针对表【T_Users】的数据库操作Service实现
* @createDate 2024-07-03 07:59:51
*/
@Service
public class TUsersServiceImpl extends ServiceImpl<TUsersMapper, TUsers>
    implements TUsersService{
    @Resource
    private TUsersMapper tUsersMapper;
    @Override
    public List<fetchUsersVo> fetchUsers() {
        List<fetchUsersVo> usersList = tUsersMapper.fetchUsers();
        return usersList;
    }
}




