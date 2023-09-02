package cn.iocoder.yudao.module.medical.convert.departments;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsCreateReqVO;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsExcelVO;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsRespVO;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsSimpleRespVO;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.DepartmentsUpdateReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T14:26:05+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
public class DepartmentsConvertImpl implements DepartmentsConvert {

    @Override
    public DepartmentsDO convert(DepartmentsCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DepartmentsDO.DepartmentsDOBuilder departmentsDO = DepartmentsDO.builder();

        departmentsDO.name( bean.getName() );
        departmentsDO.parentId( bean.getParentId() );
        departmentsDO.sort( bean.getSort() );
        departmentsDO.status( bean.getStatus() );

        return departmentsDO.build();
    }

    @Override
    public DepartmentsDO convert(DepartmentsUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        DepartmentsDO.DepartmentsDOBuilder departmentsDO = DepartmentsDO.builder();

        departmentsDO.id( bean.getId() );
        departmentsDO.name( bean.getName() );
        departmentsDO.parentId( bean.getParentId() );
        departmentsDO.sort( bean.getSort() );
        departmentsDO.status( bean.getStatus() );

        return departmentsDO.build();
    }

    @Override
    public DepartmentsRespVO convert(DepartmentsDO bean) {
        if ( bean == null ) {
            return null;
        }

        DepartmentsRespVO departmentsRespVO = new DepartmentsRespVO();

        departmentsRespVO.setName( bean.getName() );
        departmentsRespVO.setParentId( bean.getParentId() );
        departmentsRespVO.setSort( bean.getSort() );
        departmentsRespVO.setStatus( bean.getStatus() );
        departmentsRespVO.setId( bean.getId() );
        departmentsRespVO.setCreateTime( bean.getCreateTime() );

        return departmentsRespVO;
    }

    @Override
    public List<DepartmentsRespVO> convertList(List<DepartmentsDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentsRespVO> list1 = new ArrayList<DepartmentsRespVO>( list.size() );
        for ( DepartmentsDO departmentsDO : list ) {
            list1.add( convert( departmentsDO ) );
        }

        return list1;
    }

    @Override
    public List<DepartmentsSimpleRespVO> convertList03(List<DepartmentsDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentsSimpleRespVO> list1 = new ArrayList<DepartmentsSimpleRespVO>( list.size() );
        for ( DepartmentsDO departmentsDO : list ) {
            list1.add( departmentsDOToDepartmentsSimpleRespVO( departmentsDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<DepartmentsRespVO> convertPage(PageResult<DepartmentsDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<DepartmentsRespVO> pageResult = new PageResult<DepartmentsRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<DepartmentsExcelVO> convertList02(List<DepartmentsDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentsExcelVO> list1 = new ArrayList<DepartmentsExcelVO>( list.size() );
        for ( DepartmentsDO departmentsDO : list ) {
            list1.add( departmentsDOToDepartmentsExcelVO( departmentsDO ) );
        }

        return list1;
    }

    protected DepartmentsSimpleRespVO departmentsDOToDepartmentsSimpleRespVO(DepartmentsDO departmentsDO) {
        if ( departmentsDO == null ) {
            return null;
        }

        DepartmentsSimpleRespVO departmentsSimpleRespVO = new DepartmentsSimpleRespVO();

        departmentsSimpleRespVO.setId( departmentsDO.getId() );
        departmentsSimpleRespVO.setName( departmentsDO.getName() );
        departmentsSimpleRespVO.setParentId( departmentsDO.getParentId() );

        return departmentsSimpleRespVO;
    }

    protected DepartmentsExcelVO departmentsDOToDepartmentsExcelVO(DepartmentsDO departmentsDO) {
        if ( departmentsDO == null ) {
            return null;
        }

        DepartmentsExcelVO departmentsExcelVO = new DepartmentsExcelVO();

        departmentsExcelVO.setId( departmentsDO.getId() );
        departmentsExcelVO.setName( departmentsDO.getName() );
        departmentsExcelVO.setParentId( departmentsDO.getParentId() );
        departmentsExcelVO.setSort( departmentsDO.getSort() );
        departmentsExcelVO.setStatus( departmentsDO.getStatus() );
        departmentsExcelVO.setCreateTime( departmentsDO.getCreateTime() );

        return departmentsExcelVO;
    }
}
