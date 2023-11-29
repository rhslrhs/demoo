package com.example.demoo.member.web;

import com.example.demoo.member.service.MemberService;
import com.example.demoo.member.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/member/join3", method = RequestMethod.GET)
    public String getMemberJoin3() {
        return "member/join3";
    }

    @RequestMapping(value = "/member/join4", method = RequestMethod.GET)
    public String getMemberJoin4() {
        return "member/join4";
    }


    // CASE.1 - req-form, res-view
    // 'Content-Type: application/x-www-form-urlencoded'으로 보내고, (ex: form-submit)
    // view(jsp)에서 응답 처리
    @RequestMapping(value = "/member/join1", method = RequestMethod.POST)
    public String memberJoin1(Model model, @ModelAttribute MemberVo vo) {
        log.debug("## vo - email: {}, name: {}", vo.getEmail(), vo.getName());

        // call-service
        MemberVo resVo = memberService.insertMember(vo);

        // set-model&view
        model.addAttribute("memberInfo", resVo);
        return "member/join";
    }


    // CASE.2 - req-json, res-view
    // 'Content-Type: application/json'으로 보내고, (ex: ajax-json-send)
    // view(jsp)에서 응답 처리
    @RequestMapping(value = "/member/join2", method = RequestMethod.POST)
    public String memberJoin2(Model model, @RequestBody MemberVo vo) {
        log.debug("## vo - email: {}, name: {}", vo.getEmail(), vo.getName());

        // call-service
        MemberVo resVo = memberService.insertMember(vo);

        // set-model&view
        model.addAttribute("memberInfo", resVo);
        return "member/join";
    }


    // CASE.3 - req-form, res-json
    // 'Content-Type: application/x-www-form-urlencoded'으로 보내고, (ex: form-submit)
    // 클라이언트에서 json 응답 처리
    @RequestMapping(value = "/member/join3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> memberJoin3(@ModelAttribute MemberVo vo) {
        log.debug("## vo - email: {}, name: {}", vo.getEmail(), vo.getName());

        // call-service
        MemberVo resVo = memberService.insertMember(vo);

        // set-responseBody
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", resVo);
        responseBody.put("resCd", "0000");
        responseBody.put("resMsg", "OK");
        return responseBody;    // map 객체를 스프링에서 마셜링하여 json 으로 최종 응답
    }


    // CASE.4 - req-json, res-json
    // 'Content-Type: application/json'으로 보내고, (ex: ajax-json-send)
    // 클라이언트에서 json 응답 처리
    @RequestMapping(value = "/member/join4", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> memberJoin4(@RequestBody MemberVo vo) {
        log.debug("## vo - email: {}, name: {}", vo.getEmail(), vo.getName());

        // call-service
        MemberVo resVo = memberService.insertMember(vo);

        // set-responseBody
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("data", resVo);
        responseBody.put("resCd", "0000");
        responseBody.put("resMsg", "OK");
        return responseBody;    // map 객체를 스프링에서 마셜링하여 json 으로 최종 응답
    }


}
