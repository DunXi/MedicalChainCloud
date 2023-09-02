package cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 医院 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospitalsRespVO extends HospitalsBaseVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "7629")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
