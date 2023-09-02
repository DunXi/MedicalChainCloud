package cn.iocoder.yudao.module.medical.service.departments;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.datapermission.core.annotation.DataPermission;
import cn.iocoder.yudao.module.medical.dal.redis.RedisKeyConstants;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.medical.convert.departments.DepartmentsConvert;
import cn.iocoder.yudao.module.medical.dal.mysql.departments.DepartmentsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.DEPT_NOT_ENABLE;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.DEPT_NOT_FOUND;

/**
 * 科室 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DepartmentsServiceImpl implements DepartmentsService {

    @Resource
    private DepartmentsMapper departmentsMapper;

    @Override
    public Long createDepartments(DepartmentsCreateReqVO createReqVO) {
        // 插入
        DepartmentsDO departments = DepartmentsConvert.INSTANCE.convert(createReqVO);
        departmentsMapper.insert(departments);
        // 返回
        return departments.getId();
    }

    @Override
    public void updateDepartments(DepartmentsUpdateReqVO updateReqVO) {
        // 校验存在
        validateDepartmentsExists(updateReqVO.getId());
        // 更新
        DepartmentsDO updateObj = DepartmentsConvert.INSTANCE.convert(updateReqVO);
        departmentsMapper.updateById(updateObj);
    }

    @Override
    public void deleteDepartments(Long id) {
        // 校验存在
        validateDepartmentsExists(id);
        // 删除
        departmentsMapper.deleteById(id);
    }

    private void validateDepartmentsExists(Long id) {
        if (departmentsMapper.selectById(id) == null) {
            throw exception(DEPARTMENTS_NOT_EXISTS);
        }
    }

    @Override
    public DepartmentsDO getDepartments(Long id) {
        return departmentsMapper.selectById(id);
    }

    @Override
    public List<DepartmentsDO> getDepartmentsList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return departmentsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DepartmentsDO> getDepartmentsPage(DepartmentsPageReqVO pageReqVO) {
        return departmentsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<DepartmentsDO> getDepartmentsList(DepartmentsExportReqVO exportReqVO) {
        return departmentsMapper.selectList(exportReqVO);
    }

    @Override
    public List<DepartmentsDO> getChildDepartmentsList(Long id) {
        List<DepartmentsDO> children = new LinkedList<>();
        // 遍历每一层
        Collection<Long> parentIds = Collections.singleton(id);
        for (int i = 0; i < Short.MAX_VALUE; i++) { // 使用 Short.MAX_VALUE 避免 bug 场景下，存在死循环
            // 查询当前层，所有的子部门
            List<DepartmentsDO> depts = departmentsMapper.selectListByParentId(parentIds);
            // 1. 如果没有子部门，则结束遍历
            if (CollUtil.isEmpty(depts)) {
                break;
            }
            // 2. 如果有子部门，继续遍历
            children.addAll(depts);
            parentIds = convertSet(depts, DepartmentsDO::getId);
        }
        return children;
    }

    @Override
    @DataPermission(enable = false) // 禁用数据权限，避免简历不正确的缓存
    @Cacheable(cacheNames = RedisKeyConstants.DEPT_CHILDREN_ID_LIST, key = "#id")
    public Set<Long> getChildDepartmentsIdListFromCache(Long id) {
        List<DepartmentsDO> children = getChildDepartmentsList(id);
        return convertSet(children, DepartmentsDO::getId);
    }

    @Override
    public void validateDepartmentsList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return;
        }
        // 获得科室信息
        Map<Long, DepartmentsDO> deptMap = getDepartmentsMap(ids);
        // 校验
        ids.forEach(id -> {
            DepartmentsDO dept = deptMap.get(id);
            if (dept == null) {
                throw exception(DEPT_NOT_FOUND);
            }
            if (!CommonStatusEnum.ENABLE.getStatus().equals(dept.getStatus())) {
                throw exception(DEPT_NOT_ENABLE, dept.getName());
            }
        });
    }

    @Override
    public List<DepartmentsDO> getDepartmentsList(DepartmentsListReqVO reqVO) {
        return departmentsMapper.selectList(reqVO);
    }


}
