package cn.org.alan.agile.mapper;

import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.vo.user.MyselfDataGetVo;
import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author alan
* @description 针对表【T_Users】的数据库操作Mapper
* @createDate 2024-07-03 07:59:51
* @Entity cn.org.alan.exam.model/entity.TUsers
*/
public interface TUsersMapper extends BaseMapper<TUsers> {

    List<fetchUsersVo> fetchUsers(Long teamId);

    MyselfDataGetVo getMyselfData(Long userId, Long teamId);
}




