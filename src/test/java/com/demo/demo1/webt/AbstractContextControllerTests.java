package com.demo.demo1.webt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-web.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class AbstractContextControllerTests {
    @Autowired
    protected WebApplicationContext wac;
}
