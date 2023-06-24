package com.nsplit.service.impl;

import com.nsplit.model.domain.PushDTO;
import com.nsplit.model.domain.WebPushDTO;
import com.nsplit.repository.PushMapper;
import com.nsplit.service.PushService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pushService")
@RequiredArgsConstructor
public class PushServiceImpl implements PushService {

    private final PushMapper pushMapper;


    @Override
    public List<PushDTO> pushSelect() {
        return pushMapper.pushSelect();
    }
    @Override
    public ArrayList<WebPushDTO> ResBeforeSelect(int ckno) {
        return pushMapper.ResBeforeSelect(ckno);
    }
    @Override
    public List<WebPushDTO> pushWebSelect(int ckNo) {
        return pushMapper.pushWebSelect(ckNo);
    }
    @Override
    public int pushInsert(PushDTO vo) {
        return pushMapper.pushInsert(vo);
    }
    @Override
    public int pushResInsert(PushDTO vo) {
        return pushMapper.pushResInsert(vo);
    }
}