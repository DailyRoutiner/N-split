package com.nsplit.controller;


import com.nsplit.model.domain.MeetingDTO;
import com.nsplit.model.domain.MemberDTO;
import com.nsplit.model.domain.PayDTO;
import com.nsplit.service.MeetingService;
import com.nsplit.service.MemberService;
import com.nsplit.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MeetingController {

    @Resource(name="meetingService")
    private MeetingService meetingService;

    @Resource(name="payService")
    private PayService payService;

    @Resource(name="memService")
    private MemberService memService;

    @RequestMapping("/insertfee.do")
    @ResponseBody
    //@requestParam meetno가 들어가야 된다...
    public String insertPay(@RequestParam("price") int price, @RequestParam("totalfee") int totalfee, @RequestParam("meetno") int meetno){
        String resultMsg = "no";
        int result = meetingService.insertPay(new PayDTO(price, totalfee, meetno));
        if(result > 0)  {
            resultMsg = "ok";
            System.out.println("회비 추가 성공");
        }
        return resultMsg ;
    }

    // 모임 추가 폼으로 이동
    @RequestMapping(value="insertMeeting.do", method= RequestMethod.POST)
    public ModelAndView insertMeeting(){
        ModelAndView mv=new ModelAndView();
        List<MemberDTO> memberView = memService.memberSelect();
        mv.addObject("memberView", memberView);
        mv.setViewName("addTest");
        return mv;
    }

    // 친구 목록 불러오기
    @RequestMapping("/friendSelect.do")
    public ModelAndView friendSelect(@RequestParam("meetno") int meetno){
        List<PayDTO> list =  payService.friendSelect(meetno);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("jsonView");
        return mv;
    }
    //모임 추가
    @RequestMapping(value="addMeeting.do", method=RequestMethod.POST)
    public ModelAndView addSpend(@RequestParam("meetingType") int meetingType,
                                 @RequestParam("place") String place,
                                 @RequestParam("meetDate") String meetDate,
                                 @RequestParam("meetName") String meetName,
                                 @RequestParam("memberIndex") String[] rowIndex,
                                 @RequestParam("meetNo") int meetNo,
                                 HttpServletRequest req){
        int result=0;
        HttpSession session=req.getSession();
        result = meetingService.insertMeeting(new MeetingDTO(meetingType, meetName, place, meetDate, ((MemberDTO)session.getAttribute("dto")).getMemno()));
        for(int i=0; i<rowIndex.length; i++){
            result = payService.insertPayment(new PayDTO(Integer.parseInt(rowIndex[i]),meetNo));
        }
        if(result > 0){
            System.out.println("데이터 삽입 성공!");
        }else{
            System.out.println("데이터 삽입 실패");
        }
        //다시 list값을 뿌려 주기 위해 불러오는 부분..
        List<MeetingDTO> list = meetingService.meetingList(((MemberDTO)session.getAttribute("dto")).getMemno());
        ModelAndView mv=new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("main");

        return mv;
    }
    // 모임 페이지으로 들어가기
    @RequestMapping(value="valuePass.do", method=RequestMethod.POST)
    public ModelAndView valuePass(@RequestParam("manageNo") int manageNo,
                                  @RequestParam("meetNo") int meetNo,
                                  HttpServletRequest req){
        System.out.println("@@@@@@@@@@"+meetNo + manageNo);
        List<PayDTO> pd =null;
        ModelAndView mv=new ModelAndView();
        HttpSession session = req.getSession();

        // 들어간 모임이 내가 관리자인지 아닌지를 체크
        if(((MemberDTO)session.getAttribute("dto")).getMemno() == manageNo){
            pd = payService.friendSelect(meetNo);
            System.out.println("관리자 입니다");
        }else{
            pd = payService.friendSelect(meetNo);
            System.out.println("사용자 입니다");
        }
        mv.addObject("list", pd);
        mv.setViewName("meeting");
        return mv;
    }
}
