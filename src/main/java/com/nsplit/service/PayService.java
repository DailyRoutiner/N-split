package com.nsplit.service;

public interface PayService {
    List<PayDTO> paySelect();
    List<WebPushDTO> ResAfterSelect(int ckNo);
    int payUpdate(PayDTO vo);
    int payMeetUpdate(PayDTO vo);
    List<PayDTO> friendSelect(int meetno);
    int insertPayment(PayDTO pd);
}
