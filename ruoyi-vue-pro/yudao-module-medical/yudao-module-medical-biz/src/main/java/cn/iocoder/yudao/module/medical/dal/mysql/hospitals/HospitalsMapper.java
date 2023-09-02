package cn.iocoder.yudao.module.medical.dal.mysql.hospitals;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.*;

/**
 * 医院 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface HospitalsMapper extends BaseMapperX<HospitalsDO> {

    default PageResult<HospitalsDO> selectPage(HospitalsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HospitalsDO>()
                .likeIfPresent(HospitalsDO::getName, reqVO.getName())
                .likeIfPresent(HospitalsDO::getAddress, reqVO.getAddress())
                .eqIfPresent(HospitalsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(HospitalsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(HospitalsDO::getId));
    }

    default List<HospitalsDO> selectList(HospitalsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<HospitalsDO>()
                .likeIfPresent(HospitalsDO::getName, reqVO.getName())
                .likeIfPresent(HospitalsDO::getAddress, reqVO.getAddress())
                .eqIfPresent(HospitalsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(HospitalsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(HospitalsDO::getId));
    }

}
