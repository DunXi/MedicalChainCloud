package cn.iocoder.yudao.module.medical.dal.mysql.departments;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.*;

/**
 * 科室 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DepartmentsMapper extends BaseMapperX<DepartmentsDO> {

    default PageResult<DepartmentsDO> selectPage(DepartmentsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DepartmentsDO>()
                .likeIfPresent(DepartmentsDO::getName, reqVO.getName())
                .eqIfPresent(DepartmentsDO::getParentId, reqVO.getParentId())
                .eqIfPresent(DepartmentsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(DepartmentsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DepartmentsDO::getId));
    }

    default List<DepartmentsDO> selectList(DepartmentsExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DepartmentsDO>()
                .likeIfPresent(DepartmentsDO::getName, reqVO.getName())
                .eqIfPresent(DepartmentsDO::getParentId, reqVO.getParentId())
                .eqIfPresent(DepartmentsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(DepartmentsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DepartmentsDO::getId));
    }

    default List<DepartmentsDO> selectListByParentId(Collection<Long> parentIds) {
        return selectList(DepartmentsDO::getParentId, parentIds);
    }

    default List<DepartmentsDO> selectList(DepartmentsListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<DepartmentsDO>()
                .likeIfPresent(DepartmentsDO::getName, reqVO.getName())
                .eqIfPresent(DepartmentsDO::getStatus, reqVO.getStatus()));
    }
}
