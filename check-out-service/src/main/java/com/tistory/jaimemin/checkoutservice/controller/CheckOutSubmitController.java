package com.tistory.jaimemin.checkoutservice.controller;

import com.tistory.jaimemin.checkoutservice.dto.CheckOutDto;
import com.tistory.jaimemin.checkoutservice.service.SaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CheckOutSubmitController {

    private final SaveService saveService;

    @PostMapping("/submitCheckOut")
    public String submitCheckOut(CheckOutDto checkOutDto, Model model) {
        log.info("{}", checkOutDto);

        Long checkOutId = saveService.saveCheckOutData(checkOutDto);
        model.addAttribute("checkOutId", checkOutId);

        return "submitComplete";
    }
}
