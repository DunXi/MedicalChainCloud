package cn.iocoder.yudao.module.medical.service.doctor;

import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.medical.controller.admin.doctor.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.doctor.DoctorDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.medical.convert.doctor.DoctorConvert;
import cn.iocoder.yudao.module.medical.dal.mysql.doctor.DoctorMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 医生信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DoctorServiceImpl implements DoctorService {

    @Resource
    private DoctorMapper doctorMapper;

    @Autowired
    private AdminUserApi adminUserApi;

    @Override
    public Long createDoctor(DoctorCreateReqVO createReqVO) {
        // 插入
        DoctorDO doctor = DoctorConvert.INSTANCE.convert(createReqVO);
        doctorMapper.insert(doctor);
        // 返回
        return doctor.getUserId();
    }

    @Override
    public void updateDoctor(DoctorUpdateReqVO updateReqVO) {
        // 校验存在
        validateDoctorExists(updateReqVO.getUserId());
        // 更新
        DoctorDO updateObj = DoctorConvert.INSTANCE.convert(updateReqVO);
        doctorMapper.updateById(updateObj);
    }

    @Override
    public void deleteDoctor(Long id) {
        // 校验存在
        validateDoctorExists(id);
        // 删除
        doctorMapper.deleteById(id);
    }

    private void validateDoctorExists(Long id) {
        if (doctorMapper.selectById(id) == null) {
            throw exception(DOCTOR_NOT_EXISTS);
        }
    }

    @Override
    public DoctorDO getDoctor(Long id) {
        return doctorMapper.selectById(id);
    }

    @Override
    public List<DoctorDO> getDoctorList(Collection<Long> ids) {
        return doctorMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<DoctorDO> getDoctorPage(DoctorPageReqVO pageReqVO) {
        //先把pageNo-1 MySQL是从0开始的
        pageReqVO.setPageNo(pageReqVO.getPageNo() - 1);
        //查询分页数据
        List<DoctorDO> list = doctorMapper.selectDoctorPage(pageReqVO);
        //查询总数
        Long total = doctorMapper.selectTotal(pageReqVO);
        //将查询到的分页信息和总数，封装到PageResult中进行返回
        return new PageResult<>(list, total);
    }

    @Override
    public List<DoctorDO> getDoctorList(DoctorExportReqVO exportReqVO) {
        return doctorMapper.selectList(exportReqVO);
    }

}
