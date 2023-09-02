package cn.iocoder.yudao.module.medical.service.hospitaldepartment;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import cn.iocoder.yudao.module.medical.dal.mysql.hospitaldepartment.HospitalDepartmentMapper;
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
 * {@link HospitalDepartmentServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(HospitalDepartmentServiceImpl.class)
public class HospitalDepartmentServiceImplTest extends BaseDbUnitTest {

    @Resource
    private HospitalDepartmentServiceImpl hospitalDepartmentService;

    @Resource
    private HospitalDepartmentMapper hospitalDepartmentMapper;

    @Test
    public void testCreateHospitalDepartment_success() {
        // 准备参数
        HospitalDepartmentCreateReqVO reqVO = randomPojo(HospitalDepartmentCreateReqVO.class);

        // 调用
        Long hospitalDepartmentId = hospitalDepartmentService.createHospitalDepartment(reqVO);
        // 断言
        assertNotNull(hospitalDepartmentId);
        // 校验记录的属性是否正确
        HospitalDepartmentDO hospitalDepartment = hospitalDepartmentMapper.selectById(hospitalDepartmentId);
        assertPojoEquals(reqVO, hospitalDepartment);
    }

    @Test
    public void testUpdateHospitalDepartment_success() {
        // mock 数据
        HospitalDepartmentDO dbHospitalDepartment = randomPojo(HospitalDepartmentDO.class);
        hospitalDepartmentMapper.insert(dbHospitalDepartment);// @Sql: 先插入出一条存在的数据
        // 准备参数
        HospitalDepartmentUpdateReqVO reqVO = randomPojo(HospitalDepartmentUpdateReqVO.class, o -> {
            o.setId(dbHospitalDepartment.getId()); // 设置更新的 ID
        });

        // 调用
        hospitalDepartmentService.updateHospitalDepartment(reqVO);
        // 校验是否更新正确
        HospitalDepartmentDO hospitalDepartment = hospitalDepartmentMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, hospitalDepartment);
    }

    @Test
    public void testUpdateHospitalDepartment_notExists() {
        // 准备参数
        HospitalDepartmentUpdateReqVO reqVO = randomPojo(HospitalDepartmentUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> hospitalDepartmentService.updateHospitalDepartment(reqVO), HOSPITAL_DEPARTMENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteHospitalDepartment_success() {
        // mock 数据
        HospitalDepartmentDO dbHospitalDepartment = randomPojo(HospitalDepartmentDO.class);
        hospitalDepartmentMapper.insert(dbHospitalDepartment);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbHospitalDepartment.getId();

        // 调用
        hospitalDepartmentService.deleteHospitalDepartment(id);
       // 校验数据不存在了
       assertNull(hospitalDepartmentMapper.selectById(id));
    }

    @Test
    public void testDeleteHospitalDepartment_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> hospitalDepartmentService.deleteHospitalDepartment(id), HOSPITAL_DEPARTMENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetHospitalDepartmentPage() {
       // mock 数据
       HospitalDepartmentDO dbHospitalDepartment = randomPojo(HospitalDepartmentDO.class, o -> { // 等会查询到
           o.setHospitalId(null);
           o.setDepartmentId(null);
           o.setCreateTime(null);
       });
       hospitalDepartmentMapper.insert(dbHospitalDepartment);
       // 测试 hospitalId 不匹配
       hospitalDepartmentMapper.insert(cloneIgnoreId(dbHospitalDepartment, o -> o.setHospitalId(null)));
       // 测试 departmentId 不匹配
       hospitalDepartmentMapper.insert(cloneIgnoreId(dbHospitalDepartment, o -> o.setDepartmentId(null)));
       // 测试 createTime 不匹配
       hospitalDepartmentMapper.insert(cloneIgnoreId(dbHospitalDepartment, o -> o.setCreateTime(null)));
       // 准备参数
       HospitalDepartmentPageReqVO reqVO = new HospitalDepartmentPageReqVO();
       reqVO.setHospitalId(null);
       reqVO.setDepartmentId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<HospitalDepartmentDO> pageResult = hospitalDepartmentService.getHospitalDepartmentPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbHospitalDepartment, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetHospitalDepartmentList() {
       // mock 数据
       HospitalDepartmentDO dbHospitalDepartment = randomPojo(HospitalDepartmentDO.class, o -> { // 等会查询到
           o.setHospitalId(null);
           o.setDepartmentId(null);
           o.setCreateTime(null);
       });
       hospitalDepartmentMapper.insert(dbHospitalDepartment);
       // 测试 hospitalId 不匹配
       hospitalDepartmentMapper.insert(cloneIgnoreId(dbHospitalDepartment, o -> o.setHospitalId(null)));
       // 测试 departmentId 不匹配
       hospitalDepartmentMapper.insert(cloneIgnoreId(dbHospitalDepartment, o -> o.setDepartmentId(null)));
       // 测试 createTime 不匹配
       hospitalDepartmentMapper.insert(cloneIgnoreId(dbHospitalDepartment, o -> o.setCreateTime(null)));
       // 准备参数
       HospitalDepartmentExportReqVO reqVO = new HospitalDepartmentExportReqVO();
       reqVO.setHospitalId(null);
       reqVO.setDepartmentId(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<HospitalDepartmentDO> list = hospitalDepartmentService.getHospitalDepartmentList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbHospitalDepartment, list.get(0));
    }

}
