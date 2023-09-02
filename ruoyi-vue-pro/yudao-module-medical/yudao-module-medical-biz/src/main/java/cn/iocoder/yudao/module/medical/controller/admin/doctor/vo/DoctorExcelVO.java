package cn.iocoder.yudao.module.medical.controller.admin.doctor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 医生信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DoctorExcelVO {

    @ExcelProperty("用户ID")
    private Long userId;

    @ExcelProperty("医院ID")
    private Long hospitalId;

    @ExcelProperty("科室ID")
    private Long departmentId;

    @ExcelProperty("擅长")
    private String skilled;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
