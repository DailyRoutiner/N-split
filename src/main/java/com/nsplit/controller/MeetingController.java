package com.nsplit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MeetingController {


    @RequestMapping("/insertfee.do")
    @ResponseBody
    public void insertPay() {
        System.out.println("===========================");
    }

}
