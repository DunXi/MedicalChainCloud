package cn.iocoder.yudao.module.medical.service.departments;

import java.util.*;
import javax.validation.*;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 科室 Service 接口
 *
 * @author 芋道源码
 */
public interface DepartmentsService {

    /**
     * 创建科室
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDepartments(@Valid DepartmentsCreateReqVO createReqVO);

    /**
     * 更新科室
     *
     * @param updateReqVO 更新信息
     */
    void updateDepartments(@Valid DepartmentsUpdateReqVO updateReqVO);

    /**
     * 删除科室
     *
     * @param id 编号
     */
    void deleteDepartments(Long id);

    /**
     * 获得科室信息
     *
     * @param id 编号
     * @return 科室信息
     */
    DepartmentsDO getDepartments(Long id);

    /**
     * 获得科室列表
     *
     * @param ids 编号
     * @return 科室列表
     */
    List<DepartmentsDO> getDepartmentsList(Collection<Long> ids);

    /**
     * 获得科室分页
     *
     * @param pageReqVO 分页查询
     * @return 科室分页
     */
    PageResult<DepartmentsDO> getDepartmentsPage(DepartmentsPageReqVO pageReqVO);

    /**
     * 获得科室列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 科室列表
     */
    List<DepartmentsDO> getDepartmentsList(DepartmentsExportReqVO exportReqVO);


    //增加内容

    default Map<Long, DepartmentsDO> getDepartmentsMap(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyMap();
        }
        List<DepartmentsDO> list = getDepartmentsList(ids);
        return CollectionUtils.convertMap(list, DepartmentsDO::getId);
    }

    /**
     * 获得指定科室的所有子科室
     *
     * @param id 科室编号
     * @return 子科室列表
     */
    List<DepartmentsDO> getChildDepartmentsList(Long id);

    /**
     * 获得所有子科室，从缓存中
     *
     * @param id 父科室编号
     * @return 子科室列表
     */
    Set<Long> getChildDepartmentsIdListFromCache(Long id);

    /**
     * 校验科室们是否有效。如下情况，视为无效：
     * 1. 科室编号不存在
     * 2. 科室被禁用
     *
     * @param ids 角色编号数组
     */
    void validateDepartmentsList(Collection<Long> ids);

    List<DepartmentsDO> getDepartmentsList(DepartmentsListReqVO reqVO);
}
