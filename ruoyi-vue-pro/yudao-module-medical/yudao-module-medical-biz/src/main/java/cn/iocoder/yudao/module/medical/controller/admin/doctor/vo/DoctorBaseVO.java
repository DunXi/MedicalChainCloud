package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 医生信息 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class DoctorBaseVO {

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "9357")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @Schema(description = "医院ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19487")
    @NotNull(message = "医院ID不能为空")
    private Long hospitalId;

    @Schema(description = "科室ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "23531")
    @NotNull(message = "科室ID不能为空")
    private Long departmentId;

    @Schema(description = "擅长")
    private String skilled;

}
