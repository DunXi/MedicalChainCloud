package cn.iocoder.yudao.module.medical.dal.mysql.hospitaldepartment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.*;

/**
 * 医院和科室关联 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface HospitalDepartmentMapper extends BaseMapperX<HospitalDepartmentDO> {

    default PageResult<HospitalDepartmentDO> selectPage(HospitalDepartmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HospitalDepartmentDO>()
                .eqIfPresent(HospitalDepartmentDO::getHospitalId, reqVO.getHospitalId())
                .eqIfPresent(HospitalDepartmentDO::getDepartmentId, reqVO.getDepartmentId())
                .betweenIfPresent(HospitalDepartmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(HospitalDepartmentDO::getId));
    }

    default List<HospitalDepartmentDO> selectList(HospitalDepartmentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<HospitalDepartmentDO>()
                .eqIfPresent(HospitalDepartmentDO::getHospitalId, reqVO.getHospitalId())
                .eqIfPresent(HospitalDepartmentDO::getDepartmentId, reqVO.getDepartmentId())
                .betweenIfPresent(HospitalDepartmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(HospitalDepartmentDO::getId));
    }

    default List<HospitalDepartmentDO> selectBatchHospitalIds(Long hospitalId) {
        return selectList(new LambdaQueryWrapperX<HospitalDepartmentDO>()
                .eqIfPresent(HospitalDepartmentDO::getHospitalId, hospitalId)
                .orderByDesc(HospitalDepartmentDO::getId));
    }

    default void deleteByDepartmentId(Long id) {
        delete(new LambdaQueryWrapperX<HospitalDepartmentDO>()
                .eqIfPresent(HospitalDepartmentDO::getDepartmentId, id));
    }
}
