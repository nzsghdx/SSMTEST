package com.demo.demo1.service.impl;

import com.demo.demo1.dao.AppointmentDao;
import com.demo.demo1.dao.BookDao;
import com.demo.demo1.dto.AppointExecution;
import com.demo.demo1.entity.Appointment;
import com.demo.demo1.entity.Book;
import com.demo.demo1.enums.AppointStateEnum;
import com.demo.demo1.exception.AppointException;
import com.demo.demo1.exception.NoNumberException;
import com.demo.demo1.exception.RepeatAppointException;
import com.demo.demo1.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

//    设置log
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0,1000);
    }

    @Override
    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {
        //气死我了。。莫名其妙的bug
//        添加预约记录
        try {
            //减少库存
            int update=bookDao.reduceNumber(bookId);
            if (update<=0){
                throw new NoNumberException("no number!");
            }else {
//                有库存可以预约，增加一条预约记录
                int insert = appointmentDao.insertAppointment(bookId,studentId);
//                预约成功返回的应该是int类型的1
                if (insert<=0){
                    throw new RepeatAppointException("repeat appoint!");
                }else {
//                    成功预约之后从预约记录中查询刚才预约
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS,appointment);
                }
            }
        }catch (NoNumberException e1){
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppointException("appoint inner error:"+e.getMessage());
        }


    }
}
