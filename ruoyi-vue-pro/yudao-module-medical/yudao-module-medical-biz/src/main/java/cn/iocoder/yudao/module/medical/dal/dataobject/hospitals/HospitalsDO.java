package cn.iocoder.yudao.module.medical.dal.dataobject.hospitals;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 医院 DO
 *
 * @author 芋道源码
 */
@TableName("medical_hospitals")
@KeySequence("medical_hospitals_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalsDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 医院地址
     */
    private String address;
    /**
     * 邮政编码
     */
    private String postalCode;
    /**
     * 客服电话
     */
    private String servicePhone;
    /**
     * 急救电话
     */
    private String emergencyCall;
    /**
     * 状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}
