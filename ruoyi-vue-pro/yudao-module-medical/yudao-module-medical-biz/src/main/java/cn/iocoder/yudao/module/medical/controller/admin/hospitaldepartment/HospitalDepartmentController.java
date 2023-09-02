package cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment;

import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsRespVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;

import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import cn.iocoder.yudao.module.medical.convert.hospitaldepartment.HospitalDepartmentConvert;
import cn.iocoder.yudao.module.medical.service.hospitaldepartment.HospitalDepartmentService;

@Tag(name = "管理后台 - 医院和科室关联")
@RestController
@RequestMapping("/medical/hospital-department")
@Validated
public class HospitalDepartmentController {

    @Resource
    private HospitalDepartmentService hospitalDepartmentService;

    @PostMapping("/create")
    @Operation(summary = "创建医院和科室关联")
    @PreAuthorize("@ss.hasPermission('medical:hospital-department:create')")
    public CommonResult<Long> createHospitalDepartment(@Valid @RequestBody HospitalDepartmentCreateReqVO createReqVO) {
        return success(hospitalDepartmentService.createHospitalDepartment(createReqVO));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除医院和科室关联")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:hospital-department:delete')")
    public CommonResult<Boolean> deleteHospitalDepartment(@RequestParam("id") Long id) {
        hospitalDepartmentService.deleteHospitalDepartment(id);
        return success(true);
    }
    

    @GetMapping("/list")
    @Operation(summary = "获得医院和科室关联列表")
    @Parameter(name = "hospitalId", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('medical:hospital-department:query')")
    public CommonResult<List<DepartmentsRespVO>> getHospitalDepartmentList(@RequestParam("hospitalId") Long hospitalId) {
        List<DepartmentsRespVO> list = hospitalDepartmentService.getHospitalDepartmentList(hospitalId);
        return success(list);
    }


}
