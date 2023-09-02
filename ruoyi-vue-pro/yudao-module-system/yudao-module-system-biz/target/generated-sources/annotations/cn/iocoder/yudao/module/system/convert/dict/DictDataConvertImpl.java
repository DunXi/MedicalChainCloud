package cn.iocoder.yudao.module.system.convert.dict;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.api.dict.dto.DictDataRespDTO;
import cn.iocoder.yudao.module.system.controller.admin.dict.vo.data.DictDataCreateReqVO;
import cn.iocoder.yudao.module.system.controller.admin.dict.vo.data.DictDataExcelVO;
import cn.iocoder.yudao.module.system.controller.admin.dict.vo.data.DictDataRespVO;
import cn.iocoder.yudao.module.system.controller.admin.dict.vo.data.DictDataSimpleRespVO;
import cn.iocoder.yudao.module.system.controller.admin.dict.vo.data.DictDataUpdateReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.dict.DictDataDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:01+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class DictDataConvertImpl implements DictDataConvert {

    @Override
    public List<DictDataSimpleRespVO> convertList(List<DictDataDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDataSimpleRespVO> list1 = new ArrayList<DictDataSimpleRespVO>( list.size() );
        for ( DictDataDO dictDataDO : list ) {
            list1.add( dictDataDOToDictDataSimpleRespVO( dictDataDO ) );
        }

        return list1;
    }

    @Override
    public DictDataRespVO convert(DictDataDO bean) {
        if ( bean == null ) {
            return null;
        }

        DictDataRespVO dictDataRespVO = new DictDataRespVO();

        dictDataRespVO.setSort( bean.getSort() );
        dictDataRespVO.setLabel( bean.getLabel() );
        dictDataRespVO.setValue( bean.getValue() );
        dictDataRespVO.setDictType( bean.getDictType() );
        dictDataRespVO.setStatus( bean.getStatus() );
        dictDataRespVO.setColorType( bean.getColorType() );
        dictDataRespVO.setCssClass( bean.getCssClass() );
        dictDataRespVO.setRemark( bean.getRemark() );
        dictDataRespVO.setId( bean.getId() );
        dictDataRespVO.setCreateTime( bean.getCreateTime() );

        return dictDataRespVO;
    }

    @Override
    public PageResult<DictDataRespVO> convertPage(PageResult<DictDataDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<DictDataRespVO> pageResult = new PageResult<DictDataRespVO>();

        pageResult.setList( dictDataDOListToDictDataRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public DictDataDO convert(DictDataUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DictDataDO dictDataDO = new DictDataDO();

        dictDataDO.setId( bean.getId() );
        dictDataDO.setSort( bean.getSort() );
        dictDataDO.setLabel( bean.getLabel() );
        dictDataDO.setValue( bean.getValue() );
        dictDataDO.setDictType( bean.getDictType() );
        dictDataDO.setStatus( bean.getStatus() );
        dictDataDO.setColorType( bean.getColorType() );
        dictDataDO.setCssClass( bean.getCssClass() );
        dictDataDO.setRemark( bean.getRemark() );

        return dictDataDO;
    }

    @Override
    public DictDataDO convert(DictDataCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DictDataDO dictDataDO = new DictDataDO();

        dictDataDO.setSort( bean.getSort() );
        dictDataDO.setLabel( bean.getLabel() );
        dictDataDO.setValue( bean.getValue() );
        dictDataDO.setDictType( bean.getDictType() );
        dictDataDO.setStatus( bean.getStatus() );
        dictDataDO.setColorType( bean.getColorType() );
        dictDataDO.setCssClass( bean.getCssClass() );
        dictDataDO.setRemark( bean.getRemark() );

        return dictDataDO;
    }

    @Override
    public List<DictDataExcelVO> convertList02(List<DictDataDO> bean) {
        if ( bean == null ) {
            return null;
        }

        List<DictDataExcelVO> list = new ArrayList<DictDataExcelVO>( bean.size() );
        for ( DictDataDO dictDataDO : bean ) {
            list.add( dictDataDOToDictDataExcelVO( dictDataDO ) );
        }

        return list;
    }

    @Override
    public DictDataRespDTO convert02(DictDataDO bean) {
        if ( bean == null ) {
            return null;
        }

        DictDataRespDTO dictDataRespDTO = new DictDataRespDTO();

        dictDataRespDTO.setLabel( bean.getLabel() );
        dictDataRespDTO.setValue( bean.getValue() );
        dictDataRespDTO.setDictType( bean.getDictType() );
        dictDataRespDTO.setStatus( bean.getStatus() );

        return dictDataRespDTO;
    }

    protected DictDataSimpleRespVO dictDataDOToDictDataSimpleRespVO(DictDataDO dictDataDO) {
        if ( dictDataDO == null ) {
            return null;
        }

        DictDataSimpleRespVO dictDataSimpleRespVO = new DictDataSimpleRespVO();

        dictDataSimpleRespVO.setDictType( dictDataDO.getDictType() );
        dictDataSimpleRespVO.setValue( dictDataDO.getValue() );
        dictDataSimpleRespVO.setLabel( dictDataDO.getLabel() );
        dictDataSimpleRespVO.setColorType( dictDataDO.getColorType() );
        dictDataSimpleRespVO.setCssClass( dictDataDO.getCssClass() );

        return dictDataSimpleRespVO;
    }

    protected List<DictDataRespVO> dictDataDOListToDictDataRespVOList(List<DictDataDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDataRespVO> list1 = new ArrayList<DictDataRespVO>( list.size() );
        for ( DictDataDO dictDataDO : list ) {
            list1.add( convert( dictDataDO ) );
        }

        return list1;
    }

    protected DictDataExcelVO dictDataDOToDictDataExcelVO(DictDataDO dictDataDO) {
        if ( dictDataDO == null ) {
            return null;
        }

        DictDataExcelVO dictDataExcelVO = new DictDataExcelVO();

        dictDataExcelVO.setId( dictDataDO.getId() );
        dictDataExcelVO.setSort( dictDataDO.getSort() );
        dictDataExcelVO.setLabel( dictDataDO.getLabel() );
        dictDataExcelVO.setValue( dictDataDO.getValue() );
        dictDataExcelVO.setDictType( dictDataDO.getDictType() );
        dictDataExcelVO.setStatus( dictDataDO.getStatus() );

        return dictDataExcelVO;
    }
}
