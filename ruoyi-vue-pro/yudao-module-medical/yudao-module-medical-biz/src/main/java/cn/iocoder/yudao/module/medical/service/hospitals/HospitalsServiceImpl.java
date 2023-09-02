package cn.iocoder.yudao.module.medical.service.hospitals;

import cn.iocoder.yudao.module.medical.controller.admin.hospitaldepartment.vo.HospitalDepartmentCreateReqVO;
import cn.iocoder.yudao.module.medical.convert.hospitaldepartment.HospitalDepartmentConvert;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitaldepartment.HospitalDepartmentDO;
import cn.iocoder.yudao.module.medical.dal.mysql.hospitaldepartment.HospitalDepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.admin.hospitals.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.hospitals.HospitalsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.medical.convert.hospitals.HospitalsConvert;
import cn.iocoder.yudao.module.medical.dal.mysql.hospitals.HospitalsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 医院 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class HospitalsServiceImpl implements HospitalsService {

    @Resource
    private HospitalsMapper hospitalsMapper;

    @Override
    public Long createHospitals(HospitalsCreateReqVO createReqVO) {
        // 插入
        HospitalsDO hospitals = HospitalsConvert.INSTANCE.convert(createReqVO);
        hospitalsMapper.insert(hospitals);
        // 返回
        return hospitals.getId();
    }

    @Override
    public void updateHospitals(HospitalsUpdateReqVO updateReqVO) {
        // 校验存在
        validateHospitalsExists(updateReqVO.getId());
        // 更新
        HospitalsDO updateObj = HospitalsConvert.INSTANCE.convert(updateReqVO);
        hospitalsMapper.updateById(updateObj);
    }

    @Override
    public void deleteHospitals(Long id) {
        // 校验存在
        validateHospitalsExists(id);
        // 删除
        hospitalsMapper.deleteById(id);
    }

    private void validateHospitalsExists(Long id) {
        if (hospitalsMapper.selectById(id) == null) {
            throw exception(HOSPITALS_NOT_EXISTS);
        }
    }

    @Override
    public HospitalsDO getHospitals(Long id) {
        return hospitalsMapper.selectById(id);
    }

    @Override
    public List<HospitalsDO> getHospitalsList(Collection<Long> ids) {
        return hospitalsMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<HospitalsDO> getHospitalsPage(HospitalsPageReqVO pageReqVO) {
        return hospitalsMapper.selectPage(pageReqVO);
    }

    @Override
    public List<HospitalsDO> getHospitalsList(HospitalsExportReqVO exportReqVO) {
        return hospitalsMapper.selectList(exportReqVO);
    }

    @Override
    public List<HospitalsDO> getHospitalsListName() {
        return hospitalsMapper.selectList();
    }

}
