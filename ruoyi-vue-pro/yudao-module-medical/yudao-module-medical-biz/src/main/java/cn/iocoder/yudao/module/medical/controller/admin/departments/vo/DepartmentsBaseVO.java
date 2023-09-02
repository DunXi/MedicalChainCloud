package cn.iocoder.yudao.module.medical.controller.admin.departments.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 科室 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class DepartmentsBaseVO {

    @Schema(description = "科室名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotNull(message = "科室名称不能为空")
    private String name;

    @Schema(description = "父科室id", requiredMode = Schema.RequiredMode.REQUIRED, example = "9825")
    @NotNull(message = "父科室id不能为空")
    private Long parentId;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    @Schema(description = "科室状态（0正常 1停用）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "科室状态（0正常 1停用）不能为空")
    private Integer status;

}
