package com.nsplit.service.impl;


import com.nsplit.model.domain.PayDTO;
import com.nsplit.model.domain.WebPushDTO;
import com.nsplit.repository.PayMapper;
import com.nsplit.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("payService")
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PayMapper payMapper;

    @Override
    public List<PayDTO> paySelect() {
        return payMapper.paySelect();
    }

    @Override
    public List<WebPushDTO> ResAfterSelect(int ckNo) {
        return payMapper.ResAfterSelect(ckNo);
    }

    @Override
    public int payUpdate(PayDTO vo) {
        return payMapper.payUpdate(vo);
    }

    @Override
    public int payMeetUpdate(PayDTO vo) {
        return payMapper.payMeetUpdate(vo);
    }

    @Override
    public List<PayDTO> friendSelect(int meetno) {
        return payMapper.friendSelect(meetno);
    }

    @Override
    public int insertPayment(PayDTO pd) {
        return payMapper.insertPayment(pd);
    }
}
