package com.demo.demo1.dao;

import com.demo.demo1.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {
    int insertAppointment(@Param("bookId") long bookId,@Param("studentId") long studentId);
    Appointment queryByKeyWithBook(@Param("bookId") long bookId,@Param("studentId") long studentId);
}
