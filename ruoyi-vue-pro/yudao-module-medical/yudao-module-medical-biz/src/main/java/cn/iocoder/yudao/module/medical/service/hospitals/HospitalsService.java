package cn.iocoder.yudao.module.medical.service.hospitals;

import java.util.*;
import javax.validation.*;

import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentBaseVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentCreateReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 医院 Service 接口
 *
 * @author 芋道源码
 */
public interface HospitalsService {

    /**
     * 创建医院
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHospitals(@Valid HospitalsCreateReqVO createReqVO);

    /**
     * 更新医院
     *
     * @param updateReqVO 更新信息
     */
    void updateHospitals(@Valid HospitalsUpdateReqVO updateReqVO);

    /**
     * 删除医院
     *
     * @param id 编号
     */
    void deleteHospitals(Long id);

    /**
     * 获得医院
     *
     * @param id 编号
     * @return 医院
     */
    HospitalsDO getHospitals(Long id);

    /**
     * 获得医院列表
     *
     * @param ids 编号
     * @return 医院列表
     */
    List<HospitalsDO> getHospitalsList(Collection<Long> ids);

    /**
     * 获得医院分页
     *
     * @param pageReqVO 分页查询
     * @return 医院分页
     */
    PageResult<HospitalsDO> getHospitalsPage(HospitalsPageReqVO pageReqVO);

    /**
     * 获得医院列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 医院列表
     */
    List<HospitalsDO> getHospitalsList(HospitalsExportReqVO exportReqVO);

    List<HospitalsDO> getHospitalsListName();
}
