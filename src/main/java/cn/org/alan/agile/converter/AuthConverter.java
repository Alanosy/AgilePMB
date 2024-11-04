package cn.org.alan.agile.converter;

import cn.org.alan.agile.model.entity.TIssues;
import cn.org.alan.agile.model.entity.TUsers;
import cn.org.alan.agile.model.vo.auth.LoginVo;
import cn.org.alan.agile.model.vo.issue.IssuesGetVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author Alan
 * @Version
 * @Date 2024/8/23 10:03 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface AuthConverter {

    LoginVo entityToEV(TUsers u);

    TUsers VoToEntity(LoginVo l);
}
