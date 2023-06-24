package com.nsplit.service.impl;

import com.nsplit.repository.MeetingMapper;
import com.nsplit.model.domain.MeetingDTO;
import com.nsplit.model.domain.PayDTO;
import com.nsplit.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("meetingService")
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService {

    private final MeetingMapper meetingMapper;

    @Override
    public int insertPay(PayDTO payDTO) {
        return meetingMapper.insertPay(payDTO);
    }

    @Override
    public int insertMeeting(MeetingDTO meetingDTO) {
        return meetingMapper.insertMeeting(meetingDTO);
    }

    @Override
    public List<MeetingDTO> meetingList(int memno) {
        return meetingMapper.meetingList(memno);
    }

}