package com.nsplit.repository;


import com.nsplit.model.domain.MeetingDTO;
import com.nsplit.model.domain.PayDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingMapper {

    int insertPay(PayDTO payDTO);

    int insertMeeting(MeetingDTO meetingDTO);

    List<MeetingDTO> meetingList(int memno);
}
