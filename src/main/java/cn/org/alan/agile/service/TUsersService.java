package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.form.user.MyselfDataPutForm;
import cn.org.alan.agile.model.form.user.UserForm;
import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author alan
* @description 针对表【T_Users】的数据库操作Service
* @createDate 2024-07-03 07:59:51
*/
public interface TUsersService extends IService<TUsers> {

    List<fetchUsersVo> fetchUsers();

    Result getMyselfData();

    Result<String> updatePassword(UserForm userForm);

    Result updateMyselfData(MyselfDataPutForm myselfDataPutForm);
}
