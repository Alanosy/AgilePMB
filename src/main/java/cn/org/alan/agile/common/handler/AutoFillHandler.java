package cn.org.alan.agile.common.handler;


import cn.org.alan.agile.util.DateTimeUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * mybatisPlus公共字段填充处理器（元数据对象处理器）
 *
 * @Author Alan
 * @Version 1.0
 * @Date 2024/3/31 10:00
 */
@Component
public class AutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createtime", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果需要自动更新时间，可以在这里实现
    }
}
