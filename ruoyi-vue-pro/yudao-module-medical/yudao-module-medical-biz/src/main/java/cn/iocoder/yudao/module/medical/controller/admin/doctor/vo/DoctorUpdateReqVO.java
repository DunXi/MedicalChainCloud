package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 医生信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DoctorUpdateReqVO extends DoctorBaseVO {

}
