package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName T_Requirement_User
 */
@TableName(value ="T_Requirement_User")
@Data
public class TRequirementUser implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 需求id
     */
    private Long rid;

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
    //     TRequirementUser other = (TRequirementUser) that;
    //     return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
    //         && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
    //         && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()));
    // }
    //
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    //     result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
    //     result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
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
    //     sb.append(", uid=").append(uid);
    //     sb.append(", rid=").append(rid);
    //     sb.append(", serialVersionUID=").append(serialVersionUID);
    //     sb.append("]");
    //     return sb.toString();
    // }
}