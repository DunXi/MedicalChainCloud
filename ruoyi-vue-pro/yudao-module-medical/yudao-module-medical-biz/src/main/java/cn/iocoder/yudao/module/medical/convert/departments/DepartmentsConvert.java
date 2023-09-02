package cn.iocoder.yudao.module.medical.convert.departments;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;

/**
 * 科室 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DepartmentsConvert {

    DepartmentsConvert INSTANCE = Mappers.getMapper(DepartmentsConvert.class);

    DepartmentsDO convert(DepartmentsCreateReqVO bean);

    DepartmentsDO convert(DepartmentsUpdateReqVO bean);

    DepartmentsRespVO convert(DepartmentsDO bean);

    List<DepartmentsRespVO> convertList(List<DepartmentsDO> list);

    List<DepartmentsSimpleRespVO> convertList03(List<DepartmentsDO> list);

    PageResult<DepartmentsRespVO> convertPage(PageResult<DepartmentsDO> page);

    List<DepartmentsExcelVO> convertList02(List<DepartmentsDO> list);

}
