package cn.iocoder.yudao.module.member.convert.signin;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.controller.admin.signin.vo.MemberSignInRecordCreateReqVO;
import cn.iocoder.yudao.module.member.controller.admin.signin.vo.MemberSignInRecordRespVO;
import cn.iocoder.yudao.module.member.controller.admin.signin.vo.MemberSignInRecordUpdateReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.signin.MemberSignInRecordDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class MemberSignInRecordConvertImpl implements MemberSignInRecordConvert {

    @Override
    public MemberSignInRecordDO convert(MemberSignInRecordCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberSignInRecordDO.MemberSignInRecordDOBuilder memberSignInRecordDO = MemberSignInRecordDO.builder();

        memberSignInRecordDO.userId( bean.getUserId() );
        memberSignInRecordDO.day( bean.getDay() );
        memberSignInRecordDO.point( bean.getPoint() );

        return memberSignInRecordDO.build();
    }

    @Override
    public MemberSignInRecordDO convert(MemberSignInRecordUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberSignInRecordDO.MemberSignInRecordDOBuilder memberSignInRecordDO = MemberSignInRecordDO.builder();

        memberSignInRecordDO.id( bean.getId() );
        memberSignInRecordDO.userId( bean.getUserId() );
        memberSignInRecordDO.day( bean.getDay() );
        memberSignInRecordDO.point( bean.getPoint() );

        return memberSignInRecordDO.build();
    }

    @Override
    public MemberSignInRecordRespVO convert(MemberSignInRecordDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberSignInRecordRespVO memberSignInRecordRespVO = new MemberSignInRecordRespVO();

        memberSignInRecordRespVO.setUserId( bean.getUserId() );
        memberSignInRecordRespVO.setDay( bean.getDay() );
        memberSignInRecordRespVO.setPoint( bean.getPoint() );
        memberSignInRecordRespVO.setId( bean.getId() );
        memberSignInRecordRespVO.setCreateTime( bean.getCreateTime() );

        return memberSignInRecordRespVO;
    }

    @Override
    public PageResult<MemberSignInRecordRespVO> convertPage(PageResult<MemberSignInRecordDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberSignInRecordRespVO> pageResult = new PageResult<MemberSignInRecordRespVO>();

        pageResult.setList( memberSignInRecordDOListToMemberSignInRecordRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected List<MemberSignInRecordRespVO> memberSignInRecordDOListToMemberSignInRecordRespVOList(List<MemberSignInRecordDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberSignInRecordRespVO> list1 = new ArrayList<MemberSignInRecordRespVO>( list.size() );
        for ( MemberSignInRecordDO memberSignInRecordDO : list ) {
            list1.add( convert( memberSignInRecordDO ) );
        }

        return list1;
    }
}
