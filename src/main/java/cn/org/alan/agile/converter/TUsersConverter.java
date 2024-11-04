package cn.org.alan.agile.converter;

import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.form.user.UserForm;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/22 5:41 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface TUsersConverter {

    TUsers fromToEntity(UserForm userForm);
}
