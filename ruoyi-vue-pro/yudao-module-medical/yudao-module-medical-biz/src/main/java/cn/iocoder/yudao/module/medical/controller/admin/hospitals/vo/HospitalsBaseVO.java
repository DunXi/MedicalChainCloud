package cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
 * 医院 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class HospitalsBaseVO {

    @Schema(description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotNull(message = "名字不能为空")
    private String name;

    @Schema(description = "描述", example = "你说的对")
    private String description;

    @Schema(description = "医院地址")
    private String address;

    @Schema(description = "邮政编码")
    private String postalCode;

    @Schema(description = "客服电话")
    private String servicePhone;

    @Schema(description = "急救电话")
    private String emergencyCall;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
