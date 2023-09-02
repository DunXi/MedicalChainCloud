package cn.iocoder.yudao.module.medical.service.hospitals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;
import cn.iocoder.yudao.module.medical.dal.mysql.hospitals.HospitalsMapper;
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
 * {@link HospitalsServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(HospitalsServiceImpl.class)
public class HospitalsServiceImplTest extends BaseDbUnitTest {

    @Resource
    private HospitalsServiceImpl hospitalsService;

    @Resource
    private HospitalsMapper hospitalsMapper;

    @Test
    public void testCreateHospitals_success() {
        // 准备参数
        HospitalsCreateReqVO reqVO = randomPojo(HospitalsCreateReqVO.class);

        // 调用
        Long hospitalsId = hospitalsService.createHospitals(reqVO);
        // 断言
        assertNotNull(hospitalsId);
        // 校验记录的属性是否正确
        HospitalsDO hospitals = hospitalsMapper.selectById(hospitalsId);
        assertPojoEquals(reqVO, hospitals);
    }

    @Test
    public void testUpdateHospitals_success() {
        // mock 数据
        HospitalsDO dbHospitals = randomPojo(HospitalsDO.class);
        hospitalsMapper.insert(dbHospitals);// @Sql: 先插入出一条存在的数据
        // 准备参数
        HospitalsUpdateReqVO reqVO = randomPojo(HospitalsUpdateReqVO.class, o -> {
            o.setId(dbHospitals.getId()); // 设置更新的 ID
        });

        // 调用
        hospitalsService.updateHospitals(reqVO);
        // 校验是否更新正确
        HospitalsDO hospitals = hospitalsMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, hospitals);
    }

    @Test
    public void testUpdateHospitals_notExists() {
        // 准备参数
        HospitalsUpdateReqVO reqVO = randomPojo(HospitalsUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> hospitalsService.updateHospitals(reqVO), HOSPITALS_NOT_EXISTS);
    }

    @Test
    public void testDeleteHospitals_success() {
        // mock 数据
        HospitalsDO dbHospitals = randomPojo(HospitalsDO.class);
        hospitalsMapper.insert(dbHospitals);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbHospitals.getId();

        // 调用
        hospitalsService.deleteHospitals(id);
       // 校验数据不存在了
       assertNull(hospitalsMapper.selectById(id));
    }

    @Test
    public void testDeleteHospitals_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> hospitalsService.deleteHospitals(id), HOSPITALS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetHospitalsPage() {
       // mock 数据
       HospitalsDO dbHospitals = randomPojo(HospitalsDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setAddress(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       hospitalsMapper.insert(dbHospitals);
       // 测试 name 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setName(null)));
       // 测试 address 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setAddress(null)));
       // 测试 status 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setCreateTime(null)));
       // 准备参数
       HospitalsPageReqVO reqVO = new HospitalsPageReqVO();
       reqVO.setName(null);
       reqVO.setAddress(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<HospitalsDO> pageResult = hospitalsService.getHospitalsPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbHospitals, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetHospitalsList() {
       // mock 数据
       HospitalsDO dbHospitals = randomPojo(HospitalsDO.class, o -> { // 等会查询到
           o.setName(null);
           o.setAddress(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       hospitalsMapper.insert(dbHospitals);
       // 测试 name 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setName(null)));
       // 测试 address 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setAddress(null)));
       // 测试 status 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       hospitalsMapper.insert(cloneIgnoreId(dbHospitals, o -> o.setCreateTime(null)));
       // 准备参数
       HospitalsExportReqVO reqVO = new HospitalsExportReqVO();
       reqVO.setName(null);
       reqVO.setAddress(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<HospitalsDO> list = hospitalsService.getHospitalsList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbHospitals, list.get(0));
    }

}
