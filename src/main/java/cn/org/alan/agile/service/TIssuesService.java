package cn.org.alan.agile.service;

import cn.org.alan.agile.common.result.Result;
import cn.org.alan.agile.model.entity.TIssues;
import cn.org.alan.agile.model.form.issue.IssueSaveForm;
import cn.org.alan.agile.model.form.issue.IssueUpdateState;
import cn.org.alan.agile.model.form.issue.UpdateIssueForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author alan
* @description 针对表【T_Issues】的数据库操作Service
* @createDate 2024-07-03 07:59:50
*/
public interface TIssuesService extends IService<TIssues> {

    Result saveIssue(IssueSaveForm issueSaveForm);

    Result getIssue(Integer pageNum, Integer pageSize,Integer itemId,String issueType,String type);

    Result updateIssueState(IssueUpdateState issueUpdateState);

    Result<String> delIssue(Long issueId);

    Result updateIssue(UpdateIssueForm updateIssueForm);
}
