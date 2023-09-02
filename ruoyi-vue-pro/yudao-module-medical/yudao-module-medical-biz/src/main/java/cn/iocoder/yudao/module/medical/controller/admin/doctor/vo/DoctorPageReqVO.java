package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import lombok.*;

import java.util.*;

import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 医生信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DoctorPageReqVO extends PageParam {

    @Schema(description = "用户名", example = "臧敦禧")
    private String nickname;

    @Schema(description = "医院名称", example = "千佛山医院")
    private String hospitalName;

    @Schema(description = "科室名称", example = "心内科")
    private String departmentName;

    @Schema(description = "擅长")
    private String skilled;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
