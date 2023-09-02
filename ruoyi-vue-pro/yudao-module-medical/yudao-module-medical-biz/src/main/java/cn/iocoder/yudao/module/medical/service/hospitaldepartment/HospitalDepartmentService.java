package cn.iocoder.yudao.module.medical.service.hospitaldepartment;

import java.util.*;
import javax.validation.*;

import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsRespVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 医院和科室关联 Service 接口
 *
 * @author 芋道源码
 */
public interface HospitalDepartmentService {

    /**
     * 创建医院和科室关联
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHospitalDepartment(@Valid HospitalDepartmentCreateReqVO createReqVO);


    /**
     * 删除医院和科室关联
     *
     * @param id 编号
     */
    void deleteHospitalDepartment(Long id);

    /**
     * 获得医院和科室关联列表
     *
     * @param ids 编号
     * @return 医院和科室关联列表
     */
    List<DepartmentsRespVO> getHospitalDepartmentList(Long hospitalId);

    /**
     * 获得医院和科室关联分页
     *
     * @param pageReqVO 分页查询
     * @return 医院和科室关联分页
     */
    PageResult<HospitalDepartmentDO> getHospitalDepartmentPage(HospitalDepartmentPageReqVO pageReqVO);

    /**
     * 获得医院和科室关联列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 医院和科室关联列表
     */
    List<HospitalDepartmentDO> getHospitalDepartmentList(HospitalDepartmentExportReqVO exportReqVO);

}
