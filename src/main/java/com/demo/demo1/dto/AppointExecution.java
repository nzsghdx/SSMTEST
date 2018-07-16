package com.demo.demo1.dto;

import com.demo.demo1.entity.Appointment;
import com.demo.demo1.enums.AppointStateEnum;

public class AppointExecution {
    private long bookId;
    private int state;
    private String stateInfo;
    private Appointment appointment;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public AppointExecution() {
    }

    public AppointExecution(long bookId,AppointStateEnum appointStateEnum) {
        this.bookId = bookId;
        this.state=appointStateEnum.getState();
        this.stateInfo=appointStateEnum.getStateInfo();
    }

    public AppointExecution(long bookId, AppointStateEnum appointStateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state=appointStateEnum.getState();
        this.stateInfo=appointStateEnum.getStateInfo();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
