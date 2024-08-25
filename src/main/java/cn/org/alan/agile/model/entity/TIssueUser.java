package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName T_Issue_User
 */
@TableName(value ="T_Issue_User")
@Data
public class TIssueUser implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 问题id
     */
    private Long iid;

    /**
     * 用户id
     */
    private Long uid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    // @Override
    // public boolean equals(Object that) {
    //     if (this == that) {
    //         return true;
    //     }
    //     if (that == null) {
    //         return false;
    //     }
    //     if (getClass() != that.getClass()) {
    //         return false;
    //     }
    //     TIssueUser other = (TIssueUser) that;
    //     return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
    //         && (this.getIid() == null ? other.getIid() == null : this.getIid().equals(other.getIid()))
    //         && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()));
    // }
    //
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    //     result = prime * result + ((getIid() == null) ? 0 : getIid().hashCode());
    //     result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
    //     return result;
    // }
    //
    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append(getClass().getSimpleName());
    //     sb.append(" [");
    //     sb.append("Hash = ").append(hashCode());
    //     sb.append(", id=").append(id);
    //     sb.append(", iid=").append(iid);
    //     sb.append(", uid=").append(uid);
    //     sb.append(", serialVersionUID=").append(serialVersionUID);
    //     sb.append("]");
    //     return sb.toString();
    // }
}