package cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 医院和科室关联 Excel 导出 Request VO，参数和 HospitalDepartmentPageReqVO 是一致的")
@Data
public class HospitalDepartmentExportReqVO {

    @Schema(description = "医院ID", example = "6644")
    private Long hospitalId;

    @Schema(description = "科室ID", example = "23261")
    private Long departmentId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
