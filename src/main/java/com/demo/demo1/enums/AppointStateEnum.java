package com.demo.demo1.enums;

public enum AppointStateEnum {
    SUCCESS(1,"预约成功"),NO_NUMBER(0,"库存不足"),REPEAT_APPOINT(-1,"重复预约"),INNER_ERROR(-1,"系统意外");
    private int state;
    private String stateInfo;

    private AppointStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AppointStateEnum stateOf(int index){
        for (AppointStateEnum state:values()
             ) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
