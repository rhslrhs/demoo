package com.example.demoo.member.service;

import com.example.demoo.member.vo.MemberVo;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public MemberVo insertMember(MemberVo vo) {

        vo.setRegistDateTime(LocalDateTime.now());

        return vo;
    }
}
