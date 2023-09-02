package cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 医院 Excel 导出 Request VO，参数和 HospitalsPageReqVO 是一致的")
@Data
public class HospitalsExportReqVO {

    @Schema(description = "名字", example = "张三")
    private String name;

    @Schema(description = "医院地址")
    private String address;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
