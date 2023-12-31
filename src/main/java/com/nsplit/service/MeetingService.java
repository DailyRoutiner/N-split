package com.nsplit.service;


import com.nsplit.model.domain.MeetingDTO;
import com.nsplit.model.domain.PayDTO;

import java.util.List;

public interface MeetingService {
    int insertPay(PayDTO payDTO);
    int insertMeeting(MeetingDTO meetingDTO);
    List<MeetingDTO> meetingList(int memno);
}
