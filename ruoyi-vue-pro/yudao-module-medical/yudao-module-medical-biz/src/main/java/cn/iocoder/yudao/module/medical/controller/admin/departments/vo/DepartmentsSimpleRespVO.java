package cn.iocoder.yudao.module.medical.controller.admin.departments.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "管理后台 - 科室精简信息 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsSimpleRespVO {

    @Schema(description = "科室编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "科室名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道")
    private String name;

    @Schema(description = "父科室 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long parentId;

}