package cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 医院更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospitalsUpdateReqVO extends HospitalsBaseVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "7629")
    @NotNull(message = "编号不能为空")
    private Long id;

}
