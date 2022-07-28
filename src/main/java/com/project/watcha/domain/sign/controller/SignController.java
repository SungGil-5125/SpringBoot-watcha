package com.project.watcha.domain.sign.controller;

import com.project.watcha.domain.sign.dto.request.SignInDto;
import com.project.watcha.domain.sign.dto.request.SignUpDto;
import com.project.watcha.domain.sign.dto.response.SignInResponseDto;
import com.project.watcha.domain.sign.service.SignService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final SignService signService;
    private final ResponseService responseService;

    @PostMapping("/signup")
    public CommonResultResponse signup(@Valid @RequestBody SignUpDto signUpDto) {
        signService.register(signUpDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/signin")
    public CommonResultResponse signin(@Valid @RequestBody SignInDto signInDto) {
        SignInResponseDto data = signService.login(signInDto);
        return responseService.getSingleResult(data);
    }
}
