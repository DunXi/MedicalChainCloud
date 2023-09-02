package cn.iocoder.yudao.module.medical.controller.admin.doctor;

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

import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;
import cn.iocoder.yudao.module.medical.convert.doctor.DoctorConvert;
import cn.iocoder.yudao.module.medical.service.doctor.DoctorService;

@Tag(name = "管理后台 - 医生信息")
@RestController
@RequestMapping("/medical/doctor")
@Validated
public class DoctorController {

    @Resource
    private DoctorService doctorService;

    @PostMapping("/create")
    @Operation(summary = "创建医生信息")
    @PreAuthorize("@ss.hasPermission('medical:doctor:create')")
    public CommonResult<Long> createDoctor(@Valid @RequestBody DoctorCreateReqVO createReqVO) {
        return success(doctorService.createDoctor(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新医生信息")
    @PreAuthorize("@ss.hasPermission('medical:doctor:update')")
    public CommonResult<Boolean> updateDoctor(@Valid @RequestBody DoctorUpdateReqVO updateReqVO) {
        doctorService.updateDoctor(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除医生信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:doctor:delete')")
    public CommonResult<Boolean> deleteDoctor(@RequestParam("id") Long id) {
        doctorService.deleteDoctor(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得医生信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:doctor:query')")
    public CommonResult<DoctorRespVO> getDoctor(@RequestParam("id") Long id) {
        DoctorDO doctor = doctorService.getDoctor(id);
        return success(DoctorConvert.INSTANCE.convert(doctor));
    }

    @GetMapping("/list")
    @Operation(summary = "获得医生信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('medical:doctor:query')")
    public CommonResult<List<DoctorRespVO>> getDoctorList(@RequestParam("ids") Collection<Long> ids) {
        List<DoctorDO> list = doctorService.getDoctorList(ids);
        return success(DoctorConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得医生信息分页")
    @PreAuthorize("@ss.hasPermission('medical:doctor:query')")
    public CommonResult<PageResult<DoctorRespVO>> getDoctorPage(@Valid DoctorPageReqVO pageVO) {
        PageResult<DoctorDO> pageResult = doctorService.getDoctorPage(pageVO);
        return success(DoctorConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出医生信息 Excel")
    @PreAuthorize("@ss.hasPermission('medical:doctor:export')")
    @OperateLog(type = EXPORT)
    public void exportDoctorExcel(@Valid DoctorExportReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        List<DoctorDO> list = doctorService.getDoctorList(exportReqVO);
        // 导出 Excel
        List<DoctorExcelVO> datas = DoctorConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "医生信息.xls", "数据", DoctorExcelVO.class, datas);
    }

}
