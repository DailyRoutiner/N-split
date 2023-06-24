package com.nsplit.service;

public interface PushService {
    int pushInsert(PushDTO vo);
    List<PushDTO> pushSelect();
    List<WebPushDTO> pushWebSelect(int ckNo);
    ArrayList<WebPushDTO> ResBeforeSelect(int ckno);
    int pushResInsert(PushDTO vo);
}
