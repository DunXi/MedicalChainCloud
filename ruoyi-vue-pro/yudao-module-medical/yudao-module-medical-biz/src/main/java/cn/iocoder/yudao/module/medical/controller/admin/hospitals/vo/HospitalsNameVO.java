package cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HospitalsNameVO {
    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "7629")
    private Long id;
    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotNull(message = "名字不能为空")
    private String name;

}
