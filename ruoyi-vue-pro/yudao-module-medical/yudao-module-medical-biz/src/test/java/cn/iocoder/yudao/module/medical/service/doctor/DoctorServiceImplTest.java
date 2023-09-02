package cn.iocoder.yudao.module.medical.service.doctor;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;
import cn.iocoder.yudao.module.medical.dal.mysql.doctor.DoctorMapper;
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
 * {@link DoctorServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(DoctorServiceImpl.class)
public class DoctorServiceImplTest extends BaseDbUnitTest {

    @Resource
    private DoctorServiceImpl doctorService;

    @Resource
    private DoctorMapper doctorMapper;

    @Test
    public void testCreateDoctor_success() {
        // 准备参数
        DoctorCreateReqVO reqVO = randomPojo(DoctorCreateReqVO.class);

        // 调用
        Long doctorId = doctorService.createDoctor(reqVO);
        // 断言
        assertNotNull(doctorId);
        // 校验记录的属性是否正确
        DoctorDO doctor = doctorMapper.selectById(doctorId);
        assertPojoEquals(reqVO, doctor);
    }

    @Test
    public void testUpdateDoctor_success() {
        // mock 数据
        DoctorDO dbDoctor = randomPojo(DoctorDO.class);
        doctorMapper.insert(dbDoctor);// @Sql: 先插入出一条存在的数据
        // 准备参数
        DoctorUpdateReqVO reqVO = randomPojo(DoctorUpdateReqVO.class, o -> {
            o.setId(dbDoctor.getId()); // 设置更新的 ID
        });

        // 调用
        doctorService.updateDoctor(reqVO);
        // 校验是否更新正确
        DoctorDO doctor = doctorMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, doctor);
    }

    @Test
    public void testUpdateDoctor_notExists() {
        // 准备参数
        DoctorUpdateReqVO reqVO = randomPojo(DoctorUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> doctorService.updateDoctor(reqVO), DOCTOR_NOT_EXISTS);
    }

    @Test
    public void testDeleteDoctor_success() {
        // mock 数据
        DoctorDO dbDoctor = randomPojo(DoctorDO.class);
        doctorMapper.insert(dbDoctor);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbDoctor.getId();

        // 调用
        doctorService.deleteDoctor(id);
       // 校验数据不存在了
       assertNull(doctorMapper.selectById(id));
    }

    @Test
    public void testDeleteDoctor_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> doctorService.deleteDoctor(id), DOCTOR_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDoctorPage() {
       // mock 数据
       DoctorDO dbDoctor = randomPojo(DoctorDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setHospitalId(null);
           o.setDepartmentId(null);
           o.setSkilled(null);
           o.setCreateTime(null);
       });
       doctorMapper.insert(dbDoctor);
       // 测试 userId 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setUserId(null)));
       // 测试 hospitalId 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setHospitalId(null)));
       // 测试 departmentId 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setDepartmentId(null)));
       // 测试 skilled 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setSkilled(null)));
       // 测试 createTime 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setCreateTime(null)));
       // 准备参数
       DoctorPageReqVO reqVO = new DoctorPageReqVO();
       reqVO.setUserId(null);
       reqVO.setHospitalId(null);
       reqVO.setDepartmentId(null);
       reqVO.setSkilled(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<DoctorDO> pageResult = doctorService.getDoctorPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbDoctor, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetDoctorList() {
       // mock 数据
       DoctorDO dbDoctor = randomPojo(DoctorDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setHospitalId(null);
           o.setDepartmentId(null);
           o.setSkilled(null);
           o.setCreateTime(null);
       });
       doctorMapper.insert(dbDoctor);
       // 测试 userId 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setUserId(null)));
       // 测试 hospitalId 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setHospitalId(null)));
       // 测试 departmentId 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setDepartmentId(null)));
       // 测试 skilled 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setSkilled(null)));
       // 测试 createTime 不匹配
       doctorMapper.insert(cloneIgnoreId(dbDoctor, o -> o.setCreateTime(null)));
       // 准备参数
       DoctorExportReqVO reqVO = new DoctorExportReqVO();
       reqVO.setUserId(null);
       reqVO.setHospitalId(null);
       reqVO.setDepartmentId(null);
       reqVO.setSkilled(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<DoctorDO> list = doctorService.getDoctorList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbDoctor, list.get(0));
    }

}
