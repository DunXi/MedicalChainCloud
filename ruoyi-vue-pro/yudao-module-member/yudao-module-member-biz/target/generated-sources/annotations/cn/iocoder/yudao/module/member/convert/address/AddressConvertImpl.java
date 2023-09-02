package cn.iocoder.yudao.module.member.convert.address;

import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressRespVO;
import cn.iocoder.yudao.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.address.MemberAddressDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class AddressConvertImpl implements AddressConvert {

    @Override
    public MemberAddressDO convert(AppAddressCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberAddressDO.MemberAddressDOBuilder memberAddressDO = MemberAddressDO.builder();

        memberAddressDO.name( bean.getName() );
        memberAddressDO.mobile( bean.getMobile() );
        memberAddressDO.areaId( bean.getAreaId() );
        memberAddressDO.detailAddress( bean.getDetailAddress() );
        memberAddressDO.defaultStatus( bean.getDefaultStatus() );

        return memberAddressDO.build();
    }

    @Override
    public MemberAddressDO convert(AppAddressUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberAddressDO.MemberAddressDOBuilder memberAddressDO = MemberAddressDO.builder();

        memberAddressDO.id( bean.getId() );
        memberAddressDO.name( bean.getName() );
        memberAddressDO.mobile( bean.getMobile() );
        memberAddressDO.areaId( bean.getAreaId() );
        memberAddressDO.detailAddress( bean.getDetailAddress() );
        memberAddressDO.defaultStatus( bean.getDefaultStatus() );

        return memberAddressDO.build();
    }

    @Override
    public AppAddressRespVO convert(MemberAddressDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppAddressRespVO appAddressRespVO = new AppAddressRespVO();

        if ( bean.getAreaId() != null ) {
            appAddressRespVO.setAreaName( convertAreaIdToAreaName( bean.getAreaId().intValue() ) );
        }
        appAddressRespVO.setName( bean.getName() );
        appAddressRespVO.setMobile( bean.getMobile() );
        appAddressRespVO.setAreaId( bean.getAreaId() );
        appAddressRespVO.setDetailAddress( bean.getDetailAddress() );
        appAddressRespVO.setDefaultStatus( bean.getDefaultStatus() );
        appAddressRespVO.setId( bean.getId() );

        return appAddressRespVO;
    }

    @Override
    public List<AppAddressRespVO> convertList(List<MemberAddressDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppAddressRespVO> list1 = new ArrayList<AppAddressRespVO>( list.size() );
        for ( MemberAddressDO memberAddressDO : list ) {
            list1.add( convert( memberAddressDO ) );
        }

        return list1;
    }

    @Override
    public AddressRespDTO convert02(MemberAddressDO bean) {
        if ( bean == null ) {
            return null;
        }

        AddressRespDTO addressRespDTO = new AddressRespDTO();

        addressRespDTO.setId( bean.getId() );
        addressRespDTO.setUserId( bean.getUserId() );
        addressRespDTO.setName( bean.getName() );
        addressRespDTO.setMobile( bean.getMobile() );
        if ( bean.getAreaId() != null ) {
            addressRespDTO.setAreaId( bean.getAreaId().intValue() );
        }
        addressRespDTO.setDetailAddress( bean.getDetailAddress() );
        addressRespDTO.setDefaultStatus( bean.getDefaultStatus() );

        return addressRespDTO;
    }
}
