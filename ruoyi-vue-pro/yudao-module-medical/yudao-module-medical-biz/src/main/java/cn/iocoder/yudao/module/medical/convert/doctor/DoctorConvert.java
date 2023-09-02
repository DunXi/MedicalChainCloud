package cn.iocoder.yudao.module.medical.convert.doctor;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;

/**
 * 医生信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DoctorConvert {

    DoctorConvert INSTANCE = Mappers.getMapper(DoctorConvert.class);

    DoctorDO convert(DoctorCreateReqVO bean);

    DoctorDO convert(DoctorUpdateReqVO bean);

    DoctorRespVO convert(DoctorDO bean);

    List<DoctorRespVO> convertList(List<DoctorDO> list);

    PageResult<DoctorRespVO> convertPage(PageResult<DoctorDO> page);

    List<DoctorExcelVO> convertList02(List<DoctorDO> list);

}
