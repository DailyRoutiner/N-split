package com.nsplit.service;


import com.nsplit.model.dao.MeetingDAO;
import com.nsplit.model.domain.MeetingDTO;
import com.nsplit.model.domain.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("meetingService")
public interface MeetingService implements MeetingService {
    @Resource(name="meetingDAO")
    private MeetingDAO meetingDao;

    @Override
    public int insertPay(PayDTO payDTO) {
        return meetingDao.insertPay(payDTO);
    }

    @Override
    public int insertMeeting(MeetingDTO meetingDTO) {
        return meetingDao.insertMeeting(meetingDTO);
    }

    @Override
    public List<MeetingDTO> meetingList(int memno) {
        return meetingDao.meetingList(memno);
    }
}
