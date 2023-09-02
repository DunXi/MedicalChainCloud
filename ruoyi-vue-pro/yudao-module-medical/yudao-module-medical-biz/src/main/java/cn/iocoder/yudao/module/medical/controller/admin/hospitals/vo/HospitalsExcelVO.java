package cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 医院 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class HospitalsExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("名字")
    private String name;

    @ExcelProperty("描述")
    private String description;

    @ExcelProperty("医院地址")
    private String address;

    @ExcelProperty("邮政编码")
    private String postalCode;

    @ExcelProperty("客服电话")
    private String servicePhone;

    @ExcelProperty("急救电话")
    private String emergencyCall;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
