package cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 医院和科室关联 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospitalDepartmentRespVO extends HospitalDepartmentBaseVO {

    @Schema(description = "自增编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28880")
    private Long id;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
