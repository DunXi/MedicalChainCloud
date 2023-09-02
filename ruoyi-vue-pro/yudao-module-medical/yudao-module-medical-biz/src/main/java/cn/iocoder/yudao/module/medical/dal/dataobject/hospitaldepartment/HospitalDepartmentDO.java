package cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 医院和科室关联 DO
 *
 * @author 芋道源码
 */
@TableName("medical_hospital_department")
@KeySequence("medical_hospital_department_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDepartmentDO extends BaseDO {

    /**
     * 自增编号
     */
    @TableId
    private Long id;
    /**
     * 医院ID
     */
    private Long hospitalId;
    /**
     * 科室ID
     */
    private Long departmentId;

}
