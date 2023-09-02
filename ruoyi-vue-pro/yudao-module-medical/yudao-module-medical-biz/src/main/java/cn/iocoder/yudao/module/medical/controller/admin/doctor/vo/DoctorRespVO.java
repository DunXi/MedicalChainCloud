package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 医生信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DoctorRespVO extends DoctorBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 用户昵称（名字）
     */
    private String nickname;

    /**
     * 医院名字
     */
    private String hospitalName;

    /**
     * 科室名字
     */
    private String departmentName;

}
