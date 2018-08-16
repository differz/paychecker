package com.differz.paychecker.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ItsEndpoint {

    private final ItsService itsService;

    public ItsEndpoint(ItsService itsService) {
        this.itsService = itsService;
    }

    @GetMapping("/its")
    public ItsDetails getDetails(@RequestParam String number) throws IOException {
        return itsService.showItsInfo(number);
    }
}
