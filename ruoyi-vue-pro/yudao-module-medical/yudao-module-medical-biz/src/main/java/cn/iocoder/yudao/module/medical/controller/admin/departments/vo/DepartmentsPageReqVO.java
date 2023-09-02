package cn.iocoder.yudao.module.medical.controller.admin.departments.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 科室分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentsPageReqVO extends PageParam {

    @Schema(description = "科室名称", example = "赵六")
    private String name;

    @Schema(description = "父科室id", example = "9825")
    private Long parentId;

    @Schema(description = "科室状态（0正常 1停用）", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
