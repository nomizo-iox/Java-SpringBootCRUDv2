package com.nomizo.logs;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Configuration
public class Logging {

    public static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public void logs(){
        logger.info("This is INFO");
    }
}
