package cn.iocoder.yudao.module.medical.controller.admin.hospitals;

import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentBaseVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentCreateReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentRespVO;
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

import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;
import cn.iocoder.yudao.module.medical.convert.hospitals.HospitalsConvert;
import cn.iocoder.yudao.module.medical.service.hospitals.HospitalsService;

@Tag(name = "管理后台 - 医院")
@RestController
@RequestMapping("/medical/hospitals")
@Validated
public class HospitalsController {

    @Resource
    private HospitalsService hospitalsService;

    @PostMapping("/create")
    @Operation(summary = "创建医院")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:create')")
    public CommonResult<Long> createHospitals(@Valid @RequestBody HospitalsCreateReqVO createReqVO) {
        return success(hospitalsService.createHospitals(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新医院")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:update')")
    public CommonResult<Boolean> updateHospitals(@Valid @RequestBody HospitalsUpdateReqVO updateReqVO) {
        hospitalsService.updateHospitals(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除医院")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:hospitals:delete')")
    public CommonResult<Boolean> deleteHospitals(@RequestParam("id") Long id) {
        hospitalsService.deleteHospitals(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得医院")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:query')")
    public CommonResult<HospitalsRespVO> getHospitals(@RequestParam("id") Long id) {
        HospitalsDO hospitals = hospitalsService.getHospitals(id);
        return success(HospitalsConvert.INSTANCE.convert(hospitals));
    }

    @GetMapping("/list")
    @Operation(summary = "获得医院列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:query')")
    public CommonResult<List<HospitalsRespVO>> getHospitalsList(@RequestParam("ids") Collection<Long> ids) {
        List<HospitalsDO> list = hospitalsService.getHospitalsList(ids);
        return success(HospitalsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/list-name")
    @Operation(summary = "获得医院名字列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:query')")
    public CommonResult<List<HospitalsNameVO>> getHospitalsList() {
        List<HospitalsDO> list = hospitalsService.getHospitalsListName();
        return success(HospitalsConvert.INSTANCE.convertListName(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得医院分页")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:query')")
    public CommonResult<PageResult<HospitalsRespVO>> getHospitalsPage(@Valid HospitalsPageReqVO pageVO) {
        PageResult<HospitalsDO> pageResult = hospitalsService.getHospitalsPage(pageVO);
        return success(HospitalsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出医院 Excel")
    @PreAuthorize("@ss.hasPermission('medical:hospitals:export')")
    @OperateLog(type = EXPORT)
    public void exportHospitalsExcel(@Valid HospitalsExportReqVO exportReqVO,
                                     HttpServletResponse response) throws IOException {
        List<HospitalsDO> list = hospitalsService.getHospitalsList(exportReqVO);
        // 导出 Excel
        List<HospitalsExcelVO> datas = HospitalsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "医院.xls", "数据", HospitalsExcelVO.class, datas);
    }

}
