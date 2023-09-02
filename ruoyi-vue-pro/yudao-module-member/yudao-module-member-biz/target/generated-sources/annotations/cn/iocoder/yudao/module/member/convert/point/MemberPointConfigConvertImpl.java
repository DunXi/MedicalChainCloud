package cn.iocoder.yudao.module.member.convert.point;

import cn.iocoder.yudao.module.member.controller.admin.point.vo.config.MemberPointConfigRespVO;
import cn.iocoder.yudao.module.member.controller.admin.point.vo.config.MemberPointConfigSaveReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.point.MemberPointConfigDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class MemberPointConfigConvertImpl implements MemberPointConfigConvert {

    @Override
    public MemberPointConfigRespVO convert(MemberPointConfigDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberPointConfigRespVO memberPointConfigRespVO = new MemberPointConfigRespVO();

        if ( bean.getId() != null ) {
            memberPointConfigRespVO.setId( bean.getId().longValue() );
        }
        memberPointConfigRespVO.setTradeDeductEnable( bean.getTradeDeductEnable() );
        memberPointConfigRespVO.setTradeDeductUnitPrice( bean.getTradeDeductUnitPrice() );
        if ( bean.getTradeDeductMaxPrice() != null ) {
            memberPointConfigRespVO.setTradeDeductMaxPrice( bean.getTradeDeductMaxPrice().longValue() );
        }
        if ( bean.getTradeGivePoint() != null ) {
            memberPointConfigRespVO.setTradeGivePoint( bean.getTradeGivePoint().longValue() );
        }

        return memberPointConfigRespVO;
    }

    @Override
    public MemberPointConfigDO convert(MemberPointConfigSaveReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberPointConfigDO.MemberPointConfigDOBuilder memberPointConfigDO = MemberPointConfigDO.builder();

        if ( bean.getId() != null ) {
            memberPointConfigDO.id( bean.getId().intValue() );
        }
        memberPointConfigDO.tradeDeductEnable( bean.getTradeDeductEnable() );
        memberPointConfigDO.tradeDeductUnitPrice( bean.getTradeDeductUnitPrice() );
        if ( bean.getTradeDeductMaxPrice() != null ) {
            memberPointConfigDO.tradeDeductMaxPrice( bean.getTradeDeductMaxPrice().intValue() );
        }
        if ( bean.getTradeGivePoint() != null ) {
            memberPointConfigDO.tradeGivePoint( bean.getTradeGivePoint().intValue() );
        }

        return memberPointConfigDO.build();
    }
}
