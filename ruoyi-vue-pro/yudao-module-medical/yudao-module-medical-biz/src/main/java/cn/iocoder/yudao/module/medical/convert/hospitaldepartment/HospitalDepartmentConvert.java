package cn.iocoder.yudao.module.medical.convert.hospitaldepartment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;

/**
 * 医院和科室关联 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface HospitalDepartmentConvert {

    HospitalDepartmentConvert INSTANCE = Mappers.getMapper(HospitalDepartmentConvert.class);

    HospitalDepartmentDO convert(HospitalDepartmentCreateReqVO bean);

    HospitalDepartmentDO convert(HospitalDepartmentUpdateReqVO bean);

    HospitalDepartmentRespVO convert(HospitalDepartmentDO bean);

    List<HospitalDepartmentRespVO> convertList(List<HospitalDepartmentDO> list);

    PageResult<HospitalDepartmentRespVO> convertPage(PageResult<HospitalDepartmentDO> page);

    List<HospitalDepartmentExcelVO> convertList02(List<HospitalDepartmentDO> list);

}
