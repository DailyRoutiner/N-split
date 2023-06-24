package com.nsplit.controller;

import com.nsplit.model.domain.MeetingDTO;
import com.nsplit.model.domain.MemberDTO;
import com.nsplit.service.MeetingService;
import com.nsplit.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

    @Resource(name="memService")
    private MemberService memService;
    @Resource(name="meetingService")
    private MeetingService meetingService;

    @RequestMapping("/select.do")
    public ModelAndView select(){
        List<MemberDTO> list =  memService.memberSelect();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("jsonView");	//id=jsonView 객체를 찾아서 JsonView실행
        return mv;
    }

    @RequestMapping(value="Login.do", method= RequestMethod.POST)
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("mempw") String mempw,
                              HttpServletRequest req){
        ModelAndView mv=new ModelAndView("error");
        HttpSession session=req.getSession();
        MemberDTO vo = memService.isIdValid(email, mempw);
        if(vo != null){
            List<MeetingDTO> list = meetingService.meetingList(vo.getMemno());
            session.setAttribute("dto", vo);
            System.out.println(list);
            mv.addObject("list",list);
            mv.addObject("dto",vo );
            mv.setViewName("main");
            return mv;
        }
        return mv;
    }

    @RequestMapping(value="insertMember.do", method=RequestMethod.POST)
    public ModelAndView insertMember(@RequestParam("memname") String memname,
                                     @RequestParam("mempw") String mempw,
                                     @RequestParam("email") String email,
                                     @RequestParam("phonenumber") int phonenumber,
                                     HttpServletRequest req){
        MemberDTO dto = new MemberDTO(memname, mempw, email, phonenumber);
        dto.setDeviceid("82cfe0b7-b9b8-11e4-86a9-06a6fa0000b9");
        HttpSession session= req.getSession();
        ModelAndView mv=new ModelAndView();
        MemberDTO checkDto=memService.memJoinCheck(email);
        if(checkDto==null)
        {
            memService.insertMember(dto);
            session.setAttribute("dto", dto);
            mv.setViewName("main");
        }
        else
        {
            System.out.println("에러 발생");
            mv.setViewName("error");
        }
        return mv;
    }

    @RequestMapping(value="insertfacebook.do", method=RequestMethod.POST)
    public ModelAndView insertFacebook(@RequestParam("memname") String memname,
                                       @RequestParam("mempw") String mempw,
                                       @RequestParam("email") String email,
                                       @RequestParam("phonenumber") int phonenumber,
                                       HttpServletRequest req){
        MemberDTO dto = new MemberDTO(memname, mempw, email, phonenumber);
        HttpSession session= req.getSession();
        ModelAndView mv=new ModelAndView();
        MemberDTO checkDto=memService.memJoinCheck(email);
        if(checkDto==null)
        {
            memService.insertMember(dto);
            session.setAttribute("dto", dto);
            mv.setViewName("main");
        }
        else
        {
            System.out.println("에러 발생");
            mv.setViewName("error");
        }
        return mv;
    }

    @RequestMapping(value="isPwValid.do", method=RequestMethod.POST)
    public ModelAndView isPwValid(@RequestParam("mempw") String mempw,
                                  HttpServletRequest req)
    {
        ModelAndView mv=new ModelAndView();
        HttpSession session=req.getSession();

        MemberDTO dto = new MemberDTO();
        dto.setMempw(mempw);
        session.setAttribute("dto", memService.isPwValid(dto));

        mv.setViewName("main"); //id=test 객체를 찾아서 Test실행
        return mv;
    }

}
