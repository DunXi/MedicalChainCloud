package cn.iocoder.yudao.module.member.convert.signin;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.controller.admin.signin.vo.MemberSignInConfigCreateReqVO;
import cn.iocoder.yudao.module.member.controller.admin.signin.vo.MemberSignInConfigRespVO;
import cn.iocoder.yudao.module.member.controller.admin.signin.vo.MemberSignInConfigUpdateReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.signin.MemberSignInConfigDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class MemberSignInConfigConvertImpl implements MemberSignInConfigConvert {

    @Override
    public MemberSignInConfigDO convert(MemberSignInConfigCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberSignInConfigDO.MemberSignInConfigDOBuilder memberSignInConfigDO = MemberSignInConfigDO.builder();

        memberSignInConfigDO.day( bean.getDay() );
        memberSignInConfigDO.point( bean.getPoint() );

        return memberSignInConfigDO.build();
    }

    @Override
    public MemberSignInConfigDO convert(MemberSignInConfigUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberSignInConfigDO.MemberSignInConfigDOBuilder memberSignInConfigDO = MemberSignInConfigDO.builder();

        memberSignInConfigDO.id( bean.getId() );
        memberSignInConfigDO.day( bean.getDay() );
        memberSignInConfigDO.point( bean.getPoint() );

        return memberSignInConfigDO.build();
    }

    @Override
    public MemberSignInConfigRespVO convert(MemberSignInConfigDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberSignInConfigRespVO memberSignInConfigRespVO = new MemberSignInConfigRespVO();

        memberSignInConfigRespVO.setDay( bean.getDay() );
        memberSignInConfigRespVO.setPoint( bean.getPoint() );
        memberSignInConfigRespVO.setId( bean.getId() );
        memberSignInConfigRespVO.setCreateTime( bean.getCreateTime() );

        return memberSignInConfigRespVO;
    }

    @Override
    public List<MemberSignInConfigRespVO> convertList(List<MemberSignInConfigDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberSignInConfigRespVO> list1 = new ArrayList<MemberSignInConfigRespVO>( list.size() );
        for ( MemberSignInConfigDO memberSignInConfigDO : list ) {
            list1.add( convert( memberSignInConfigDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<MemberSignInConfigRespVO> convertPage(PageResult<MemberSignInConfigDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberSignInConfigRespVO> pageResult = new PageResult<MemberSignInConfigRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
