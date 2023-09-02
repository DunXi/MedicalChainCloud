package cn.iocoder.yudao.module.medical.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * System 错误码枚举类
 * <p>
 * system 系统，使用 1-002-000-000 段
 */
public interface ErrorCodeConstants {

    ErrorCode HOSPITALS_NOT_EXISTS = new ErrorCode(1001, "医院不存在");

    ErrorCode DEPARTMENTS_NOT_EXISTS = new ErrorCode(1002, "科室不存在");

    ErrorCode DOCTOR_NOT_EXISTS = new ErrorCode(1004, "医生信息不存在");
}
