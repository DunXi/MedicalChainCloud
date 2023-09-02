package cn.iocoder.yudao.module.medical.service.doctor;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 医生信息 Service 接口
 *
 * @author 芋道源码
 */
public interface DoctorService {

    /**
     * 创建医生信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDoctor(@Valid DoctorCreateReqVO createReqVO);

    /**
     * 更新医生信息
     *
     * @param updateReqVO 更新信息
     */
    void updateDoctor(@Valid DoctorUpdateReqVO updateReqVO);

    /**
     * 删除医生信息
     *
     * @param id 编号
     */
    void deleteDoctor(Long id);

    /**
     * 获得医生信息
     *
     * @param id 编号
     * @return 医生信息
     */
    DoctorDO getDoctor(Long id);

    /**
     * 获得医生信息列表
     *
     * @param ids 编号
     * @return 医生信息列表
     */
    List<DoctorDO> getDoctorList(Collection<Long> ids);

    /**
     * 获得医生信息分页
     *
     * @param pageReqVO 分页查询
     * @return 医生信息分页
     */
    PageResult<DoctorDO> getDoctorPage(DoctorPageReqVO pageReqVO);

    /**
     * 获得医生信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 医生信息列表
     */
    List<DoctorDO> getDoctorList(DoctorExportReqVO exportReqVO);

}
