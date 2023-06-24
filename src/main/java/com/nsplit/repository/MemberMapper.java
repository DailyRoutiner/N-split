package com.nsplit.repository;

import com.nsplit.model.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDTO> memberSelect();
    MemberDTO isIdValid(MemberDTO vo);
    MemberDTO memJoinCheck(String email);
    //지윤이가 만든 멤버
    int insertMember(MemberDTO dto);
    int updateMember(MemberDTO dto);
    int deleteMember(MemberDTO dto);
    MemberDTO isPwValid(MemberDTO dto);
    List<MemberDTO> memPicSelect(int memno);//upload
    int updatePicture(MemberDTO dto);
    //지윤이가 만든 멤버
}
