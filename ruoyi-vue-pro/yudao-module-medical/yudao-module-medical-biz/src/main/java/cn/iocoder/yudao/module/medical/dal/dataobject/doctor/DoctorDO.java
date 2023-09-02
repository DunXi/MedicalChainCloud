package cn.iocoder.yudao.module.medical.dal.dataobject.doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 医生信息 DO
 *
 * @author 芋道源码
 */
@TableName("medical_doctor")
@KeySequence("medical_doctor_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDO extends BaseDO {
    /**
     * 用户ID
     */
    @TableId
    private Long userId;
    /**
     * 医院ID
     */
    private Long hospitalId;
    /**
     * 科室ID
     */
    private Long departmentId;
    /**
     * 擅长
     */
    private String skilled;

    /**
     * 用户昵称（名字）
     */
    private String nickname;

    /**
     * 医院名字
     */
    private String hospitalName;

    /**
     * 科室名字
     */
    private String departmentName;

    @Schema(description = "用户性别，参见 SexEnum 枚举类", example = "1")
    private Integer sex;

}
