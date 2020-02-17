package com.working.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getMessage(String param) {
        System.out.println("Method took a message. Param: "+param);
        return param;
    }
}
