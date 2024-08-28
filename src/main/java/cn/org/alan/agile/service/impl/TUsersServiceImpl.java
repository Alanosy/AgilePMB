package cn.org.alan.agile.service.impl;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.converter.TUsersConverter;
import cn.org.alan.agile.model.form.user.MyselfDataPutForm;
import cn.org.alan.agile.model.form.user.UserForm;
import cn.org.alan.agile.model.vo.user.MyselfDataGetVo;
import cn.org.alan.agile.model.vo.user.fetchUsersVo;
import cn.org.alan.agile.util.SecurityUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.service.TUsersService;
import cn.org.alan.agile.mapper.TUsersMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private TUsersConverter tUsersConverter;
    @Override
    public List<fetchUsersVo> fetchUsers() {
        List<fetchUsersVo> usersList = tUsersMapper.fetchUsers(SecurityUtil.getTeamId());
        return usersList;
    }

    @Override
    public Result getMyselfData() {
        MyselfDataGetVo result = tUsersMapper.getMyselfData(SecurityUtil.getUserId(),SecurityUtil.getTeamId());
        return Result.success("请求成功",result);
    }

    @Override
    public Result<String> updatePassword(UserForm userForm) {
        if (!userForm.getNewPassword().equals(userForm.getCheckedPassword())) {
            return Result.failed("两次密码不一致");
        }
        Long userId = SecurityUtil.getUserId();
        if (!new BCryptPasswordEncoder()
                .matches(userForm.getOriginPassword(),tUsersMapper.selectById(userId).getPassword())) {
            return Result.failed("旧密码错误");
        }
        //密码加密
        userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getNewPassword()));
        userForm.setId(userId);
        int updated = tUsersMapper.updateById(tUsersConverter.fromToEntity(userForm));
        //密码修改成功清除redis的token，让用户重新登录
        if (updated > 0) {
            // stringRedisTemplate.delete(request.getSession().getId() + "token");
            return Result.success("修改成功，请重新登录");
        }
        return Result.failed("旧密码错误");

    }

    @Override
    public Result updateMyselfData(MyselfDataPutForm myselfDataPutForm) {
        LambdaUpdateWrapper<TUsers> tUsersLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        tUsersLambdaUpdateWrapper.eq(TUsers::getId,SecurityUtil.getUserId())
                .set(TUsers::getRealname,myselfDataPutForm.getRealName());
        int update = tUsersMapper.update(tUsersLambdaUpdateWrapper);
        if (update > 0) {
            // stringRedisTemplate.delete(request.getSession().getId() + "token");
            return Result.success("修改成功");
        }
        return Result.failed("修改失败");
    }
}




