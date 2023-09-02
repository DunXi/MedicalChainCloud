package cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 医院和科室关联 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class HospitalDepartmentExcelVO {

    @ExcelProperty("自增编号")
    private Long id;

    @ExcelProperty("医院ID")
    private Long hospitalId;

    @ExcelProperty("科室ID")
    private Long departmentId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
