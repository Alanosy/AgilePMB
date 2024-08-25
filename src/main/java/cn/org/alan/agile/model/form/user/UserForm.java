package cn.org.alan.agile.model.form.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


/**
 * @Author Alan
 * @Version 1.0
 * @Date 2024/3/29 15:17
 */
@Data
public class UserForm {

    private Long id;

    private LocalDateTime createTime;


    //校验器注解
    //EasyExcel注解，映射关系
    private String userName;
    private String password;
    private String realName;
    private Integer roleId;


    private String originPassword;
    private String newPassword;
    private String checkedPassword;

}
