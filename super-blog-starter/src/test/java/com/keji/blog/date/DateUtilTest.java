package com.keji.blog.date;

import com.keji.blog.util.DateUtil;
import org.junit.Test;

/**
 * @author wb-ny291824
 * @version $Id: DateUtilTest.java, v 0.1 2018-01-05 11:07 wb-ny291824 Exp $$
 */
public class DateUtilTest {

    @Test
    public void 测试后一天() {

        String currentDate = "2017-12-31";
        String specifiedDayAfter = DateUtil.getSpecifiedDayAfter(currentDate);
        System.out.println(specifiedDayAfter);

    }

}
