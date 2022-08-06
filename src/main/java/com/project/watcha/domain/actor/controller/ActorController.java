package com.project.watcha.domain.actor.controller;

import com.project.watcha.domain.actor.dto.request.RegisterActorDto;
import com.project.watcha.domain.actor.service.ActorService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final ResponseService responseService;

    @PostMapping("register/actor")
    public CommonResultResponse registerActor(
            @RequestPart(value = "actorDto") RegisterActorDto registerActorDto,
            @RequestParam(required = false, value = "image") MultipartFile file) {
        actorService.registerActor(registerActorDto, file);
        return responseService.getSuccessResult();
    }
}
