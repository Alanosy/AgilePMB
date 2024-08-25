package cn.org.alan.agile.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName T_Team_Project
 */
@TableName(value ="T_Team_Project")
@Data
public class TTeamProject implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 团队id
     */
    private Long tid;

    /**
     * 项目id
     */
    private Long pid;

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
    //     TTeamProject other = (TTeamProject) that;
    //     return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
    //         && (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
    //         && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
    // }
    //
    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    //     result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
    //     result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
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
    //     sb.append(", pid=").append(pid);
    //     sb.append(", serialVersionUID=").append(serialVersionUID);
    //     sb.append("]");
    //     return sb.toString();
    // }
}