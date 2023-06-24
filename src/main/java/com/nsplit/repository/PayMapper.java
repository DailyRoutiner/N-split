package com.nsplit.repository;

import com.nsplit.model.domain.PayDTO;
import com.nsplit.model.domain.WebPushDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {

    List<PayDTO> paySelect();
    int payUpdate(PayDTO vo);
    int payMeetUpdate(PayDTO vo);
    List<PayDTO> friendSelect(int meetno);
    List<WebPushDTO> ResAfterSelect(int ckNo);
    int insertPayment(PayDTO pd);


}
