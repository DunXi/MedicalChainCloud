package cn.iocoder.yudao.module.medical.convert.doctor;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.DoctorCreateReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.DoctorExcelVO;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.DoctorRespVO;
import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.DoctorUpdateReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:05+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class DoctorConvertImpl implements DoctorConvert {

    @Override
    public DoctorDO convert(DoctorCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DoctorDO.DoctorDOBuilder doctorDO = DoctorDO.builder();

        doctorDO.userId( bean.getUserId() );
        doctorDO.hospitalId( bean.getHospitalId() );
        doctorDO.departmentId( bean.getDepartmentId() );
        doctorDO.skilled( bean.getSkilled() );

        return doctorDO.build();
    }

    @Override
    public DoctorDO convert(DoctorUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DoctorDO.DoctorDOBuilder doctorDO = DoctorDO.builder();

        doctorDO.userId( bean.getUserId() );
        doctorDO.hospitalId( bean.getHospitalId() );
        doctorDO.departmentId( bean.getDepartmentId() );
        doctorDO.skilled( bean.getSkilled() );

        return doctorDO.build();
    }

    @Override
    public DoctorRespVO convert(DoctorDO bean) {
        if ( bean == null ) {
            return null;
        }

        DoctorRespVO doctorRespVO = new DoctorRespVO();

        doctorRespVO.setUserId( bean.getUserId() );
        doctorRespVO.setHospitalId( bean.getHospitalId() );
        doctorRespVO.setDepartmentId( bean.getDepartmentId() );
        doctorRespVO.setSkilled( bean.getSkilled() );
        doctorRespVO.setCreateTime( bean.getCreateTime() );
        doctorRespVO.setNickname( bean.getNickname() );
        doctorRespVO.setHospitalName( bean.getHospitalName() );
        doctorRespVO.setDepartmentName( bean.getDepartmentName() );

        return doctorRespVO;
    }

    @Override
    public List<DoctorRespVO> convertList(List<DoctorDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorRespVO> list1 = new ArrayList<DoctorRespVO>( list.size() );
        for ( DoctorDO doctorDO : list ) {
            list1.add( convert( doctorDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<DoctorRespVO> convertPage(PageResult<DoctorDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<DoctorRespVO> pageResult = new PageResult<DoctorRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<DoctorExcelVO> convertList02(List<DoctorDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorExcelVO> list1 = new ArrayList<DoctorExcelVO>( list.size() );
        for ( DoctorDO doctorDO : list ) {
            list1.add( doctorDOToDoctorExcelVO( doctorDO ) );
        }

        return list1;
    }

    protected DoctorExcelVO doctorDOToDoctorExcelVO(DoctorDO doctorDO) {
        if ( doctorDO == null ) {
            return null;
        }

        DoctorExcelVO doctorExcelVO = new DoctorExcelVO();

        doctorExcelVO.setUserId( doctorDO.getUserId() );
        doctorExcelVO.setHospitalId( doctorDO.getHospitalId() );
        doctorExcelVO.setDepartmentId( doctorDO.getDepartmentId() );
        doctorExcelVO.setSkilled( doctorDO.getSkilled() );
        doctorExcelVO.setCreateTime( doctorDO.getCreateTime() );

        return doctorExcelVO;
    }
}
