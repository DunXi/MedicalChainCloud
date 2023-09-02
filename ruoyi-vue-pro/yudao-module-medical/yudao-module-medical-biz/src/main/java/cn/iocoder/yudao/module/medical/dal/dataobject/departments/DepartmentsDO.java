package cn.iocoder.yudao.module.medical.dal.dataobject.departments;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 科室 DO
 *
 * @author 芋道源码
 */
@TableName("medical_departments")
@KeySequence("medical_departments_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsDO extends BaseDO {

    /**
     * 科室id
     */
    @TableId
    private Long id;
    /**
     * 科室名称
     */
    private String name;
    /**
     * 父科室id
     */
    private Long parentId;
    /**
     * 显示顺序
     */
    private Integer sort;
    /**
     * 科室状态（0正常 1停用）
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}
