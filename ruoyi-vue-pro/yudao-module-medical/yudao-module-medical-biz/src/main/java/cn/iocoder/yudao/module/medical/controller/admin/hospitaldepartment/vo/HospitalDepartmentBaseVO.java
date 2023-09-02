package cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 医院和科室关联 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class HospitalDepartmentBaseVO {

    @Schema(description = "医院ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "6644")
    @NotNull(message = "医院ID不能为空")
    private Long hospitalId;

    @Schema(description = "科室ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "23261")
    @NotNull(message = "科室ID不能为空")
    private Long departmentId;

}
