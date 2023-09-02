package cn.iocoder.yudao.module.member.convert.point;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.controller.admin.point.vo.recrod.MemberPointRecordCreateReqVO;
import cn.iocoder.yudao.module.member.controller.admin.point.vo.recrod.MemberPointRecordRespVO;
import cn.iocoder.yudao.module.member.controller.admin.point.vo.recrod.MemberPointRecordUpdateReqVO;
import cn.iocoder.yudao.module.member.dal.dataobject.point.MemberPointRecordDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class MemberPointRecordConvertImpl implements MemberPointRecordConvert {

    @Override
    public MemberPointRecordDO convert(MemberPointRecordCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberPointRecordDO.MemberPointRecordDOBuilder memberPointRecordDO = MemberPointRecordDO.builder();

        memberPointRecordDO.bizId( bean.getBizId() );
        memberPointRecordDO.bizType( bean.getBizType() );
        memberPointRecordDO.type( bean.getType() );
        memberPointRecordDO.title( bean.getTitle() );
        memberPointRecordDO.description( bean.getDescription() );
        memberPointRecordDO.point( bean.getPoint() );
        memberPointRecordDO.totalPoint( bean.getTotalPoint() );
        memberPointRecordDO.status( bean.getStatus() );
        memberPointRecordDO.userId( bean.getUserId() );
        memberPointRecordDO.freezingTime( bean.getFreezingTime() );
        memberPointRecordDO.thawingTime( bean.getThawingTime() );

        return memberPointRecordDO.build();
    }

    @Override
    public MemberPointRecordDO convert(MemberPointRecordUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberPointRecordDO.MemberPointRecordDOBuilder memberPointRecordDO = MemberPointRecordDO.builder();

        memberPointRecordDO.id( bean.getId() );
        memberPointRecordDO.bizId( bean.getBizId() );
        memberPointRecordDO.bizType( bean.getBizType() );
        memberPointRecordDO.type( bean.getType() );
        memberPointRecordDO.title( bean.getTitle() );
        memberPointRecordDO.description( bean.getDescription() );
        memberPointRecordDO.point( bean.getPoint() );
        memberPointRecordDO.totalPoint( bean.getTotalPoint() );
        memberPointRecordDO.status( bean.getStatus() );
        memberPointRecordDO.userId( bean.getUserId() );
        memberPointRecordDO.freezingTime( bean.getFreezingTime() );
        memberPointRecordDO.thawingTime( bean.getThawingTime() );

        return memberPointRecordDO.build();
    }

    @Override
    public MemberPointRecordRespVO convert(MemberPointRecordDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberPointRecordRespVO memberPointRecordRespVO = new MemberPointRecordRespVO();

        memberPointRecordRespVO.setBizId( bean.getBizId() );
        memberPointRecordRespVO.setBizType( bean.getBizType() );
        memberPointRecordRespVO.setType( bean.getType() );
        memberPointRecordRespVO.setTitle( bean.getTitle() );
        memberPointRecordRespVO.setDescription( bean.getDescription() );
        memberPointRecordRespVO.setPoint( bean.getPoint() );
        memberPointRecordRespVO.setTotalPoint( bean.getTotalPoint() );
        memberPointRecordRespVO.setStatus( bean.getStatus() );
        memberPointRecordRespVO.setUserId( bean.getUserId() );
        memberPointRecordRespVO.setFreezingTime( bean.getFreezingTime() );
        memberPointRecordRespVO.setThawingTime( bean.getThawingTime() );
        memberPointRecordRespVO.setId( bean.getId() );
        memberPointRecordRespVO.setCreateTime( bean.getCreateTime() );

        return memberPointRecordRespVO;
    }

    @Override
    public PageResult<MemberPointRecordRespVO> convertPage(PageResult<MemberPointRecordDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberPointRecordRespVO> pageResult = new PageResult<MemberPointRecordRespVO>();

        pageResult.setList( memberPointRecordDOListToMemberPointRecordRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected List<MemberPointRecordRespVO> memberPointRecordDOListToMemberPointRecordRespVOList(List<MemberPointRecordDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberPointRecordRespVO> list1 = new ArrayList<MemberPointRecordRespVO>( list.size() );
        for ( MemberPointRecordDO memberPointRecordDO : list ) {
            list1.add( convert( memberPointRecordDO ) );
        }

        return list1;
    }
}
