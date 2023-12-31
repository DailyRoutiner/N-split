package com.nsplit.service;

import com.nsplit.model.domain.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> memberSelect();
    int insertMember(MemberDTO dto);
    MemberDTO isIdValid(String email, String mempw);
    MemberDTO memJoinCheck(String email);
    int updateMember(MemberDTO dto);
    int deleteMember(MemberDTO dto);
    MemberDTO isPwValid(MemberDTO dto);
    List<MemberDTO> memPicSelect(int memno);//upload
    int updatePicture(MemberDTO dto);
}
