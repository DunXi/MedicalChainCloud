package cn.iocoder.yudao.module.medical.convert.hospitals;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;

/**
 * 医院 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface HospitalsConvert {

    HospitalsConvert INSTANCE = Mappers.getMapper(HospitalsConvert.class);

    HospitalsDO convert(HospitalsCreateReqVO bean);

    HospitalsDO convert(HospitalsUpdateReqVO bean);

    HospitalsRespVO convert(HospitalsDO bean);

    List<HospitalsRespVO> convertList(List<HospitalsDO> list);

    PageResult<HospitalsRespVO> convertPage(PageResult<HospitalsDO> page);

    List<HospitalsExcelVO> convertList02(List<HospitalsDO> list);

    List<HospitalsNameVO> convertListName(List<HospitalsDO> list);
}
