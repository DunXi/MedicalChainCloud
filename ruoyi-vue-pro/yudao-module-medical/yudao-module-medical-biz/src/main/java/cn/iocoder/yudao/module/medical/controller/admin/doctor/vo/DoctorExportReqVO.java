package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 医生信息 Excel 导出 Request VO，参数和 DoctorPageReqVO 是一致的")
@Data
public class DoctorExportReqVO {

    @Schema(description = "用户ID", example = "9357")
    private Long userId;

    @Schema(description = "医院ID", example = "19487")
    private Long hospitalId;

    @Schema(description = "科室ID", example = "23531")
    private Long departmentId;

    @Schema(description = "擅长")
    private String skilled;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
