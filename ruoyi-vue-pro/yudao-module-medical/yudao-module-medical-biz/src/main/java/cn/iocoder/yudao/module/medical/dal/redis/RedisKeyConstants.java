package cn.iocoder.yudao.module.medical.dal.redis;

/**
 * System Redis Key 枚举类
 *
 * @author 芋道源码
 */
public interface RedisKeyConstants {

    /**
     * 指定科室的所有子科室编号数组的缓存
     * <p>
     * KEY 格式：departments_children_ids:{id}
     * VALUE 数据类型：String 子科室编号集合
     */
    String DEPT_CHILDREN_ID_LIST = "departments_children_ids";


}
