package cn.iocoder.yudao.module.medical.service.hospitaldepartment;

import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsPageReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsRespVO;
import cn.iocoder.yudao.module.medical.convert.departments.DepartmentsConvert;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import cn.iocoder.yudao.module.medical.service.departments.DepartmentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.medical.convert.hospitaldepartment.HospitalDepartmentConvert;
import cn.iocoder.yudao.module.medical.dal.mysql.hospitaldepartment.HospitalDepartmentMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 医院和科室关联 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class HospitalDepartmentServiceImpl implements HospitalDepartmentService {

    @Resource
    private HospitalDepartmentMapper hospitalDepartmentMapper;

    @Resource
    private DepartmentsService departmentsService;

    @Override
    public Long createHospitalDepartment(HospitalDepartmentCreateReqVO createReqVO) {
        // 插入
        HospitalDepartmentDO hospitalDepartment = HospitalDepartmentConvert.INSTANCE.convert(createReqVO);
        hospitalDepartmentMapper.insert(hospitalDepartment);
        // 返回
        return hospitalDepartment.getId();
    }

    @Override
    public void deleteHospitalDepartment(Long id) {
        // 删除
        hospitalDepartmentMapper.deleteByDepartmentId(id);
    }

    @Override
    public List<DepartmentsRespVO> getHospitalDepartmentList(Long hospitalId) {
        List<HospitalDepartmentDO> hospitalDepartmentDOS = hospitalDepartmentMapper.selectBatchHospitalIds(hospitalId);
        List<Long> list = hospitalDepartmentDOS.stream().map(h -> h.getDepartmentId()).collect(Collectors.toList());
        List<DepartmentsDO> departmentsList = departmentsService.getDepartmentsList(list);
        List<DepartmentsRespVO> departmentsRespVOS = DepartmentsConvert.INSTANCE.convertList(departmentsList);
        return departmentsRespVOS;
    }

    @Override
    public PageResult<HospitalDepartmentDO> getHospitalDepartmentPage(HospitalDepartmentPageReqVO pageReqVO) {
        return hospitalDepartmentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<HospitalDepartmentDO> getHospitalDepartmentList(HospitalDepartmentExportReqVO exportReqVO) {
        return hospitalDepartmentMapper.selectList(exportReqVO);
    }

}
