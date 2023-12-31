package com.nsplit.service;

import com.nsplit.model.domain.PushDTO;
import com.nsplit.model.domain.WebPushDTO;

import java.util.ArrayList;
import java.util.List;

public interface PushService {
    int pushInsert(PushDTO vo);
    List<PushDTO> pushSelect();
    List<WebPushDTO> pushWebSelect(int ckNo);
    ArrayList<WebPushDTO> ResBeforeSelect(int ckno);
    int pushResInsert(PushDTO vo);
}
