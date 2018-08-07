package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VipAspect {

    private static final Logger logger = LoggerFactory.getLogger(VipAspect.class);

    private long start;

    // aop

    @Pointcut("@annotation(com.example.demo.utils.Timer)")
    public void timer() {
        System.out.println("time aspect");
    }

    @Before("timer()")
    public void before() {
        start = System.currentTimeMillis();
    }

    @After("timer()")
    public void after() {
        long now = System.currentTimeMillis();
        logger.info("job took time {}ms in summary", (now - start) );
    }


}
