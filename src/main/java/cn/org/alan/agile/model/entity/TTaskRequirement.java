package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName T_Task_Requirement
 */
@TableName(value ="T_Task_Requirement")
@Data
public class TTaskRequirement implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 任务id
     */
    private Long tid;

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
    //     TTaskRequirement other = (TTaskRequirement) that;
    //     return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
    //         && (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
    //         && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()));
    // }
    //
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    //     result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
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
    //     sb.append(", tid=").append(tid);
    //     sb.append(", rid=").append(rid);
    //     sb.append(", serialVersionUID=").append(serialVersionUID);
    //     sb.append("]");
    //     return sb.toString();
    // }
}