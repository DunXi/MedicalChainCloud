package cn.iocoder.yudao.module.medical.controller.admin.departments.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 科室 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentsRespVO extends DepartmentsBaseVO {

    @Schema(description = "科室id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13352")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
