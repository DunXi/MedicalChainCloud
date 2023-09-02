package cn.iocoder.yudao.module.medical.controller.admin.departments;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

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

import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import cn.iocoder.yudao.module.medical.convert.departments.DepartmentsConvert;
import cn.iocoder.yudao.module.medical.service.departments.DepartmentsService;

@Tag(name = "管理后台 - 科室")
@RestController
@RequestMapping("/medical/departments")
@Validated
public class DepartmentsController {

    @Resource
    private DepartmentsService departmentsService;

    @PostMapping("/create")
    @Operation(summary = "创建科室")
    @PreAuthorize("@ss.hasPermission('medical:departments:create')")
    public CommonResult<Long> createDepartments(@Valid @RequestBody DepartmentsCreateReqVO createReqVO) {
        return success(departmentsService.createDepartments(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新科室")
    @PreAuthorize("@ss.hasPermission('medical:departments:update')")
    public CommonResult<Boolean> updateDepartments(@Valid @RequestBody DepartmentsUpdateReqVO updateReqVO) {
        departmentsService.updateDepartments(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除科室")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:departments:delete')")
    public CommonResult<Boolean> deleteDepartments(@RequestParam("id") Long id) {
        departmentsService.deleteDepartments(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得科室")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:departments:query')")
    public CommonResult<DepartmentsRespVO> getDepartments(@RequestParam("id") Long id) {
        DepartmentsDO departments = departmentsService.getDepartments(id);
        return success(DepartmentsConvert.INSTANCE.convert(departments));
    }

    @GetMapping("/list")
    @Operation(summary = "获得科室列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('medical:departments:query')")
    public CommonResult<List<DepartmentsRespVO>> getDepartmentsList(DepartmentsListReqVO reqVO) {
        List<DepartmentsDO> list = departmentsService.getDepartmentsList(reqVO);
        return success(DepartmentsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "获取部门精简信息列表", description = "只包含被开启的部门，主要用于前端的下拉选项")
    public CommonResult<List<DepartmentsSimpleRespVO>> getSimpleDeptList() {
        // 获得部门列表，只要开启状态的
        DepartmentsListReqVO reqVO = new DepartmentsListReqVO();
        reqVO.setStatus(CommonStatusEnum.ENABLE.getStatus());
        List<DepartmentsDO> list = departmentsService.getDepartmentsList(reqVO);
        // 排序后，返回给前端
        list.sort(Comparator.comparing(DepartmentsDO::getSort));
        return success(DepartmentsConvert.INSTANCE.convertList03(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得科室分页")
    @PreAuthorize("@ss.hasPermission('medical:departments:query')")
    public CommonResult<PageResult<DepartmentsRespVO>> getDepartmentsPage(@Valid DepartmentsPageReqVO pageVO) {
        PageResult<DepartmentsDO> pageResult = departmentsService.getDepartmentsPage(pageVO);
        return success(DepartmentsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出科室 Excel")
    @PreAuthorize("@ss.hasPermission('medical:departments:export')")
    @OperateLog(type = EXPORT)
    public void exportDepartmentsExcel(@Valid DepartmentsExportReqVO exportReqVO,
                                       HttpServletResponse response) throws IOException {
        List<DepartmentsDO> list = departmentsService.getDepartmentsList(exportReqVO);
        // 导出 Excel
        List<DepartmentsExcelVO> datas = DepartmentsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "科室.xls", "数据", DepartmentsExcelVO.class, datas);
    }

}
