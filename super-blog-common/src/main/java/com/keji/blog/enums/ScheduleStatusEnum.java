package com.keji.blog.enums;

/**
 * @author wb-ny291824
 * @version $Id: ScheduleStatusEnum.java, v 0.1 2017-11-02 11:41 wb-ny291824 Exp $$
 */
public enum ScheduleStatusEnum {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 暂停
     */
    PAUSE(1);

    private int value;

    private ScheduleStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
