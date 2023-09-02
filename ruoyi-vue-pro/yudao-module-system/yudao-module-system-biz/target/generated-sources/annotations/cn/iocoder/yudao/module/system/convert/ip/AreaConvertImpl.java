package cn.iocoder.yudao.module.system.convert.ip;

import cn.iocoder.yudao.framework.ip.core.Area;
import cn.iocoder.yudao.module.system.controller.admin.ip.vo.AreaNodeRespVO;
import cn.iocoder.yudao.module.system.controller.admin.ip.vo.AreaNodeSimpleRespVO;
import cn.iocoder.yudao.module.system.controller.app.ip.vo.AppAreaNodeRespVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:01+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class AreaConvertImpl implements AreaConvert {

    @Override
    public List<AreaNodeRespVO> convertList(List<Area> list) {
        if ( list == null ) {
            return null;
        }

        List<AreaNodeRespVO> list1 = new ArrayList<AreaNodeRespVO>( list.size() );
        for ( Area area : list ) {
            list1.add( areaToAreaNodeRespVO( area ) );
        }

        return list1;
    }

    @Override
    public List<AreaNodeSimpleRespVO> convertList2(List<Area> list) {
        if ( list == null ) {
            return null;
        }

        List<AreaNodeSimpleRespVO> list1 = new ArrayList<AreaNodeSimpleRespVO>( list.size() );
        for ( Area area : list ) {
            list1.add( convert( area ) );
        }

        return list1;
    }

    @Override
    public AreaNodeSimpleRespVO convert(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaNodeSimpleRespVO areaNodeSimpleRespVO = new AreaNodeSimpleRespVO();

        areaNodeSimpleRespVO.setLeaf( convertAreaType( area.getType() ) );
        areaNodeSimpleRespVO.setId( area.getId() );
        areaNodeSimpleRespVO.setName( area.getName() );

        return areaNodeSimpleRespVO;
    }

    @Override
    public List<AppAreaNodeRespVO> convertList3(List<Area> list) {
        if ( list == null ) {
            return null;
        }

        List<AppAreaNodeRespVO> list1 = new ArrayList<AppAreaNodeRespVO>( list.size() );
        for ( Area area : list ) {
            list1.add( areaToAppAreaNodeRespVO( area ) );
        }

        return list1;
    }

    protected AreaNodeRespVO areaToAreaNodeRespVO(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaNodeRespVO areaNodeRespVO = new AreaNodeRespVO();

        areaNodeRespVO.setId( area.getId() );
        areaNodeRespVO.setName( area.getName() );
        areaNodeRespVO.setChildren( convertList( area.getChildren() ) );

        return areaNodeRespVO;
    }

    protected AppAreaNodeRespVO areaToAppAreaNodeRespVO(Area area) {
        if ( area == null ) {
            return null;
        }

        AppAreaNodeRespVO appAreaNodeRespVO = new AppAreaNodeRespVO();

        appAreaNodeRespVO.setId( area.getId() );
        appAreaNodeRespVO.setName( area.getName() );
        appAreaNodeRespVO.setChildren( convertList3( area.getChildren() ) );

        return appAreaNodeRespVO;
    }
}
