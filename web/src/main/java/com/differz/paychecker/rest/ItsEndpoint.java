package com.differz.paychecker.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItsEndpoint {

    private final ItsService itsService;

    public ItsEndpoint(ItsService itsService) {
        this.itsService = itsService;
    }

    @GetMapping("/its")
    public ItsDetails getDetailsByNumber(@RequestParam Optional<String> number,
                                         @RequestParam Optional<String> id) throws IOException {
        if (number.isPresent()) {
            return itsService.showItsByNumber(number.get());
        }
        return itsService.showItsById(id.orElse("---"));
    }
}
