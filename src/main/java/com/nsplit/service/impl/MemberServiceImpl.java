package com.nsplit.service.impl;

import com.nsplit.model.domain.MemberDTO;
import com.nsplit.repository.MemberMapper;
import com.nsplit.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memService")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public List<MemberDTO> memberSelect() {
        return memberMapper.memberSelect();
    }

    @Override
    public int insertMember(MemberDTO dto) {
        return memberMapper.insertMember(dto);
    }

    @Override
    public MemberDTO isIdValid(String email, String mempw) {
        return memberMapper.isIdValid(new MemberDTO(email, mempw));
    }
    @Override
    public MemberDTO memJoinCheck(String email) {
        return memberMapper.memJoinCheck(email);
    }

    @Override
    public MemberDTO isPwValid(MemberDTO dto){
        return memberMapper.isPwValid(dto);
    }
    @Override
    public int updateMember(MemberDTO dto){
        return memberMapper.updateMember(dto);
    }
    @Override
    public int deleteMember(MemberDTO dto){
        return memberMapper.deleteMember(dto);
    }
    @Override//upload
    public List<MemberDTO> memPicSelect(int memno){
        return memberMapper.memPicSelect(memno);
    }
    @Override
    public int updatePicture(MemberDTO dto){
        return memberMapper.updatePicture(dto);
    }
}
