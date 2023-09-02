package cn.iocoder.yudao.module.medical.convert.hospitaldepartment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentCreateReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentExcelVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentRespVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentUpdateReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:05+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class HospitalDepartmentConvertImpl implements HospitalDepartmentConvert {

    @Override
    public HospitalDepartmentDO convert(HospitalDepartmentCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        HospitalDepartmentDO.HospitalDepartmentDOBuilder hospitalDepartmentDO = HospitalDepartmentDO.builder();

        hospitalDepartmentDO.hospitalId( bean.getHospitalId() );
        hospitalDepartmentDO.departmentId( bean.getDepartmentId() );

        return hospitalDepartmentDO.build();
    }

    @Override
    public HospitalDepartmentDO convert(HospitalDepartmentUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        HospitalDepartmentDO.HospitalDepartmentDOBuilder hospitalDepartmentDO = HospitalDepartmentDO.builder();

        hospitalDepartmentDO.id( bean.getId() );
        hospitalDepartmentDO.hospitalId( bean.getHospitalId() );
        hospitalDepartmentDO.departmentId( bean.getDepartmentId() );

        return hospitalDepartmentDO.build();
    }

    @Override
    public HospitalDepartmentRespVO convert(HospitalDepartmentDO bean) {
        if ( bean == null ) {
            return null;
        }

        HospitalDepartmentRespVO hospitalDepartmentRespVO = new HospitalDepartmentRespVO();

        hospitalDepartmentRespVO.setHospitalId( bean.getHospitalId() );
        hospitalDepartmentRespVO.setDepartmentId( bean.getDepartmentId() );
        hospitalDepartmentRespVO.setId( bean.getId() );
        hospitalDepartmentRespVO.setCreateTime( bean.getCreateTime() );

        return hospitalDepartmentRespVO;
    }

    @Override
    public List<HospitalDepartmentRespVO> convertList(List<HospitalDepartmentDO> list) {
        if ( list == null ) {
            return null;
        }

        List<HospitalDepartmentRespVO> list1 = new ArrayList<HospitalDepartmentRespVO>( list.size() );
        for ( HospitalDepartmentDO hospitalDepartmentDO : list ) {
            list1.add( convert( hospitalDepartmentDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<HospitalDepartmentRespVO> convertPage(PageResult<HospitalDepartmentDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<HospitalDepartmentRespVO> pageResult = new PageResult<HospitalDepartmentRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<HospitalDepartmentExcelVO> convertList02(List<HospitalDepartmentDO> list) {
        if ( list == null ) {
            return null;
        }

        List<HospitalDepartmentExcelVO> list1 = new ArrayList<HospitalDepartmentExcelVO>( list.size() );
        for ( HospitalDepartmentDO hospitalDepartmentDO : list ) {
            list1.add( hospitalDepartmentDOToHospitalDepartmentExcelVO( hospitalDepartmentDO ) );
        }

        return list1;
    }

    protected HospitalDepartmentExcelVO hospitalDepartmentDOToHospitalDepartmentExcelVO(HospitalDepartmentDO hospitalDepartmentDO) {
        if ( hospitalDepartmentDO == null ) {
            return null;
        }

        HospitalDepartmentExcelVO hospitalDepartmentExcelVO = new HospitalDepartmentExcelVO();

        hospitalDepartmentExcelVO.setId( hospitalDepartmentDO.getId() );
        hospitalDepartmentExcelVO.setHospitalId( hospitalDepartmentDO.getHospitalId() );
        hospitalDepartmentExcelVO.setDepartmentId( hospitalDepartmentDO.getDepartmentId() );
        hospitalDepartmentExcelVO.setCreateTime( hospitalDepartmentDO.getCreateTime() );

        return hospitalDepartmentExcelVO;
    }
}
