package cn.iocoder.yudao.module.medical.controller.admin.departments.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 科室 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DepartmentsExcelVO {

    @ExcelProperty("科室id")
    private Long id;

    @ExcelProperty("科室名称")
    private String name;

    @ExcelProperty("父科室id")
    private Long parentId;

    @ExcelProperty("显示顺序")
    private Integer sort;

    @ExcelProperty(value = "科室状态（0正常 1停用）", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
