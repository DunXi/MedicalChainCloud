package cn.iocoder.yudao.module.medical.convert.hospitals;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.HospitalsCreateReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.HospitalsExcelVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.HospitalsNameVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.HospitalsRespVO;
import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.HospitalsUpdateReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:05+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class HospitalsConvertImpl implements HospitalsConvert {

    @Override
    public HospitalsDO convert(HospitalsCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        HospitalsDO.HospitalsDOBuilder hospitalsDO = HospitalsDO.builder();

        hospitalsDO.name( bean.getName() );
        hospitalsDO.description( bean.getDescription() );
        hospitalsDO.address( bean.getAddress() );
        hospitalsDO.postalCode( bean.getPostalCode() );
        hospitalsDO.servicePhone( bean.getServicePhone() );
        hospitalsDO.emergencyCall( bean.getEmergencyCall() );
        hospitalsDO.status( bean.getStatus() );

        return hospitalsDO.build();
    }

    @Override
    public HospitalsDO convert(HospitalsUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        HospitalsDO.HospitalsDOBuilder hospitalsDO = HospitalsDO.builder();

        hospitalsDO.id( bean.getId() );
        hospitalsDO.name( bean.getName() );
        hospitalsDO.description( bean.getDescription() );
        hospitalsDO.address( bean.getAddress() );
        hospitalsDO.postalCode( bean.getPostalCode() );
        hospitalsDO.servicePhone( bean.getServicePhone() );
        hospitalsDO.emergencyCall( bean.getEmergencyCall() );
        hospitalsDO.status( bean.getStatus() );

        return hospitalsDO.build();
    }

    @Override
    public HospitalsRespVO convert(HospitalsDO bean) {
        if ( bean == null ) {
            return null;
        }

        HospitalsRespVO hospitalsRespVO = new HospitalsRespVO();

        hospitalsRespVO.setName( bean.getName() );
        hospitalsRespVO.setDescription( bean.getDescription() );
        hospitalsRespVO.setAddress( bean.getAddress() );
        hospitalsRespVO.setPostalCode( bean.getPostalCode() );
        hospitalsRespVO.setServicePhone( bean.getServicePhone() );
        hospitalsRespVO.setEmergencyCall( bean.getEmergencyCall() );
        hospitalsRespVO.setStatus( bean.getStatus() );
        hospitalsRespVO.setId( bean.getId() );
        hospitalsRespVO.setCreateTime( bean.getCreateTime() );

        return hospitalsRespVO;
    }

    @Override
    public List<HospitalsRespVO> convertList(List<HospitalsDO> list) {
        if ( list == null ) {
            return null;
        }

        List<HospitalsRespVO> list1 = new ArrayList<HospitalsRespVO>( list.size() );
        for ( HospitalsDO hospitalsDO : list ) {
            list1.add( convert( hospitalsDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<HospitalsRespVO> convertPage(PageResult<HospitalsDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<HospitalsRespVO> pageResult = new PageResult<HospitalsRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<HospitalsExcelVO> convertList02(List<HospitalsDO> list) {
        if ( list == null ) {
            return null;
        }

        List<HospitalsExcelVO> list1 = new ArrayList<HospitalsExcelVO>( list.size() );
        for ( HospitalsDO hospitalsDO : list ) {
            list1.add( hospitalsDOToHospitalsExcelVO( hospitalsDO ) );
        }

        return list1;
    }

    @Override
    public List<HospitalsNameVO> convertListName(List<HospitalsDO> list) {
        if ( list == null ) {
            return null;
        }

        List<HospitalsNameVO> list1 = new ArrayList<HospitalsNameVO>( list.size() );
        for ( HospitalsDO hospitalsDO : list ) {
            list1.add( hospitalsDOToHospitalsNameVO( hospitalsDO ) );
        }

        return list1;
    }

    protected HospitalsExcelVO hospitalsDOToHospitalsExcelVO(HospitalsDO hospitalsDO) {
        if ( hospitalsDO == null ) {
            return null;
        }

        HospitalsExcelVO hospitalsExcelVO = new HospitalsExcelVO();

        hospitalsExcelVO.setId( hospitalsDO.getId() );
        hospitalsExcelVO.setName( hospitalsDO.getName() );
        hospitalsExcelVO.setDescription( hospitalsDO.getDescription() );
        hospitalsExcelVO.setAddress( hospitalsDO.getAddress() );
        hospitalsExcelVO.setPostalCode( hospitalsDO.getPostalCode() );
        hospitalsExcelVO.setServicePhone( hospitalsDO.getServicePhone() );
        hospitalsExcelVO.setEmergencyCall( hospitalsDO.getEmergencyCall() );
        hospitalsExcelVO.setStatus( hospitalsDO.getStatus() );
        hospitalsExcelVO.setCreateTime( hospitalsDO.getCreateTime() );

        return hospitalsExcelVO;
    }

    protected HospitalsNameVO hospitalsDOToHospitalsNameVO(HospitalsDO hospitalsDO) {
        if ( hospitalsDO == null ) {
            return null;
        }

        HospitalsNameVO hospitalsNameVO = new HospitalsNameVO();

        hospitalsNameVO.setId( hospitalsDO.getId() );
        hospitalsNameVO.setName( hospitalsDO.getName() );

        return hospitalsNameVO;
    }
}
