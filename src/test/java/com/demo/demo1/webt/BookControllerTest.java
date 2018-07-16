package com.demo.demo1.webt;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//开启单元测试
@RunWith(SpringJUnit4ClassRunner.class)
//配置事务：把transactionManager注入到bean之后可以在这里使用,开启回滚
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
//开启事务
@Transactional
public class BookControllerTest extends AbstractContextControllerTests{
    private MockMvc mockMvc;
    private String listUrl="/book/list";
    private String detailUrl="/book/{bookId}/detail";
    private String appointUrl="/book/{bookId}/appoint";
    private long bookId=1000;

    @Before
    public void setup(){
        this.mockMvc=webAppContextSetup(this.wac).alwaysExpect(status().isOk()).alwaysDo(print()).build();
    }

    @Test
    public void list() throws Exception{
        this.mockMvc.perform(get(listUrl)).andExpect(view().name("list"));
    }

    @Test
    public void existDetail() throws Exception{
        this.mockMvc.perform(get(detailUrl,bookId)).andExpect(view().name("detail")).andExpect(model().attributeExists("book"));
    }

    @Test
    public void notExistDetail() throws Exception{
        this.mockMvc.perform(get(detailUrl,1100)).andExpect(forwardedUrl("/book/list"));
    }

    @Test
    public void appointTest() throws Exception{
        this.mockMvc.perform(post(appointUrl,bookId).param("studentId","1").accept(MediaType.APPLICATION_JSON)).andExpect(content().contentType("application/json;charset=utf-8"));
    }

}
