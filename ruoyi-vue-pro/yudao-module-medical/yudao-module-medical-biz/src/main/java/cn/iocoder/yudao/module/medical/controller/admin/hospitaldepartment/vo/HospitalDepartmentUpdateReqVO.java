package cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 医院和科室关联更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospitalDepartmentUpdateReqVO extends HospitalDepartmentBaseVO {

    @Schema(description = "自增编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28880")
    @NotNull(message = "自增编号不能为空")
    private Long id;

}
