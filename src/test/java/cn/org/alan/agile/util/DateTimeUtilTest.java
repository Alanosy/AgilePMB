package cn.org.alan.agile.util;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author Alan
 * @Version
 * @Date 2024/5/28 11:28 PM
 */ class DateTimeUtilTest {


    @Test
    void getDate() {

    }

    @Test
    void dateToStr() {
        System.out.println(DateTimeUtil.dateToStr(DateTimeUtil.getDate()));
    }
}