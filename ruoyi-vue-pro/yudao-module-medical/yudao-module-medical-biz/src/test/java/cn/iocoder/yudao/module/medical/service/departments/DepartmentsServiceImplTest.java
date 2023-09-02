package cn.iocoder.yudao.module.medical.service.departments;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.medical.controller.admin.departments.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.departments.DepartmentsDO;
import cn.iocoder.yudao.module.medical.dal.mysql.departments.DepartmentsMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link DepartmentsServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(DepartmentsServiceImpl.class)
public class DepartmentsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DepartmentsServiceImpl departmentsService;

    @Resource
    private DepartmentsMapper departmentsMapper;

    @Test
    public void testCreateDepartments_success() {
        // 准备参数
        DepartmentsCreateReqVO reqVO = randomPojo(DepartmentsCreateReqVO.class);

        // 调用
        Long departmentsId = departmentsService.createDepartments(reqVO);
        // 断言
        assertNotNull(departmentsId);
        // 校验记录的属性是否正确
        DepartmentsDO departments = departmentsMapper.selectById(departmentsId);
        assertPojoEquals(reqVO, departments);
    }

    @Test
    public void testUpdateDepartments_success() {
        // mock 数据
        DepartmentsDO dbDepartments = randomPojo(DepartmentsDO.class);
        departmentsMapper.insert(dbDepartments);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DepartmentsUpdateReqVO reqVO = randomPojo(DepartmentsUpdateReqVO.class, o -> {
            o.setId(dbDepartments.getId()); // 设置更新的 ID
        });

        // 调用
        departmentsService.updateDepartments(reqVO);
        // 校验是否更新正确
        DepartmentsDO departments = departmentsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, departments);
    }

    @Test
    public void testUpdateDepartments_notExists() {
        // 准备参数
        DepartmentsUpdateReqVO reqVO = randomPojo(DepartmentsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> departmentsService.updateDepartments(reqVO), DEPARTMENTS_NOT_EXISTS);
    }

    @Test
    public void testDeleteDepartments_success() {
        // mock 数据
        DepartmentsDO dbDepartments = randomPojo(DepartmentsDO.class);
        departmentsMapper.insert(dbDepartments);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbDepartments.getId();

        // 调用
        departmentsService.deleteDepartments(id);
       // 校验数据不存在了
       assertNull(departmentsMapper.selectById(id));
    }

    @Test
    public void testDeleteDepartments_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> departmentsService.deleteDepartments(id), DEPARTMENTS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDepartmentsPage() {
       // mock 数据
       DepartmentsDO dbDepartments = randomPojo(DepartmentsDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setParentId(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       departmentsMapper.insert(dbDepartments);
       // 测试 name 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setName(null)));
       // 测试 parentId 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setParentId(null)));
       // 测试 status 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setCreateTime(null)));
       // 准备参数
       DepartmentsPageReqVO reqVO = new DepartmentsPageReqVO();
       reqVO.setName(null);
       reqVO.setParentId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<DepartmentsDO> pageResult = departmentsService.getDepartmentsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDepartments, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDepartmentsList() {
       // mock 数据
       DepartmentsDO dbDepartments = randomPojo(DepartmentsDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setParentId(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       departmentsMapper.insert(dbDepartments);
       // 测试 name 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setName(null)));
       // 测试 parentId 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setParentId(null)));
       // 测试 status 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       departmentsMapper.insert(cloneIgnoreId(dbDepartments, o -> o.setCreateTime(null)));
       // 准备参数
       DepartmentsExportReqVO reqVO = new DepartmentsExportReqVO();
       reqVO.setName(null);
       reqVO.setParentId(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<DepartmentsDO> list = departmentsService.getDepartmentsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDepartments, list.get(0));
    }

}
