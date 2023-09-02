package cn.iocoder.yudao.module.medical.dal.mysql.doctor;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.*;
import org.apache.ibatis.annotations.Param;

/**
 * 医生信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DoctorMapper extends BaseMapperX<DoctorDO> {

    /**
     * @param reqVO
     * @return
     */
    List<DoctorDO> selectDoctorPage(@Param("reqVO") DoctorPageReqVO reqVO);

    default List<DoctorDO> selectList(DoctorExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DoctorDO>()
                .eqIfPresent(DoctorDO::getUserId, reqVO.getUserId())
                .eqIfPresent(DoctorDO::getHospitalId, reqVO.getHospitalId())
                .eqIfPresent(DoctorDO::getDepartmentId, reqVO.getDepartmentId())
                .likeIfPresent(DoctorDO::getSkilled, reqVO.getSkilled())
                .betweenIfPresent(DoctorDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DoctorDO::getUserId));
    }

    Long selectTotal(@Param("reqVO") DoctorPageReqVO reqVO);
}
