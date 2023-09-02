package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 医生信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DoctorCreateReqVO extends DoctorBaseVO {

}
