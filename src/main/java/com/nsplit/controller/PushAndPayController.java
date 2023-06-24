package com.nsplit.controller;

import com.nsplit.model.domain.MemberDTO;
import com.nsplit.model.domain.PayDTO;
import com.nsplit.model.domain.PushDTO;
import com.nsplit.model.domain.WebPushDTO;
import com.nsplit.service.MemberService;
import com.nsplit.service.PayService;
import com.nsplit.service.PushService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PushAndPayController {

    @Resource(name="memService")
    private MemberService memService;

    @Resource(name="pushService")
    private PushService pushService;

    @Resource(name="payService")
    private PayService payService;

    @RequestMapping("/pay.do")
    @ResponseBody
    public String paying(PayDTO vo){
        System.out.println(vo);
        List<PayDTO> list=payService.paySelect();
        String resultMsg="no";
        int resultPrice=0;
        int resultTotal=0;

        for(int i=0;i<list.size();i++)
        {
            if(vo.getAccount().equals(list.get(i).getAccount()) && vo.getCarPw().equals(list.get(i).getCarPw()))
            {
                list.get(i).setPrice(list.get(i).getPrice()-vo.getPrice());
                resultPrice=payService.payUpdate(list.get(i));
                list.get(i).setTotalfee(list.get(i).getTotalfee()-vo.getPrice());
                resultTotal=payService.payMeetUpdate(list.get(i));
            }
        }
        if((resultPrice > 0) && (resultTotal > 0))
        {
            resultMsg = "ok";
        }
        return resultMsg;
    }

    @RequestMapping("/selectMessage.do" )
    public ModelAndView selectMessage(HttpServletRequest req){
        HttpSession session = req.getSession();
        ModelAndView mv = new ModelAndView();
        ArrayList<WebPushDTO> wpsBefore = pushService.ResBeforeSelect((int)((MemberDTO)session.getAttribute("dto")).getMemno());// 2=로그인한 유저의 memno
        mv.addObject("list", wpsBefore);
        mv.setViewName("jsonView");
        return mv;
    }
    @RequestMapping("/selectDevice.do")
    @ResponseBody
    public String select(String vo,HttpServletRequest req){
        HttpSession session=req.getSession();
        String result="";

        List<MemberDTO> memberInfo =  memService.memberSelect();
        System.out.println((int)((MemberDTO)session.getAttribute("dto")).getMemno());
        System.out.println(vo);
        for(int i=0;i<memberInfo.size();i++)
        {
            if(vo.equals(memberInfo.get(i).getMemname()))
            {
                System.out.println(vo);
                result=memberInfo.get(i).getDeviceid();
                session.setAttribute("receivedMemno", memberInfo.get(i).getMemno());

            }
        }
        return result;
    }
    @RequestMapping("/pushWebInsert.do")
    @ResponseBody
    public String pushInsert(PushDTO vo, HttpServletRequest req){
        HttpSession session=req.getSession();
        String resultMsg = "no";
        int result=0;
        PushDTO dto = new PushDTO();
        dto.setCkNo((int)session.getAttribute("receivedMemno"));//상대방의 memno
        dto.setMemno((int)((MemberDTO)session.getAttribute("dto")).getMemno());
        dto.setMeetno(1);
        dto.setContent(vo.getContent()); //보내는 메시지
        if(vo.getAlramtime().equals("")) //db에 보내는 메시지 저장
        {
            result =pushService.pushInsert(dto);
        }
        else
        {
            dto.setAlramtime(vo.getAlramtime());
            result =pushService.pushResInsert(dto);
        }

        if(result > 0 )  {
            resultMsg = "ok";
        }
        return resultMsg;
    }
}
