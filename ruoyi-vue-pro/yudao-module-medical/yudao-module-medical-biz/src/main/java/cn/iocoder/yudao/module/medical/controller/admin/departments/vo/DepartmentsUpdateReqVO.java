package cn.iocoder.yudao.module.medical.controller.admin.departments.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 科室更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DepartmentsUpdateReqVO extends DepartmentsBaseVO {

    @Schema(description = "科室id", requiredMode = Schema.RequiredMode.REQUIRED, example = "13352")
    @NotNull(message = "科室id不能为空")
    private Long id;

}
