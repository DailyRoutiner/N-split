package com.nsplit.repository;


import com.nsplit.model.domain.PushDTO;
import com.nsplit.model.domain.WebPushDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PushMapper {
    int pushInsert(PushDTO vo);
    List<PushDTO> pushSelect();
    List<WebPushDTO> pushWebSelect(int ckNo);
    ArrayList<WebPushDTO> ResBeforeSelect(int ckno);
    int pushResInsert(PushDTO vo);
}
