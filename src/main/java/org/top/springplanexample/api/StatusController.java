package org.top.springplanexample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.springplanexample.api.message.StringMessage;

@RestController
@RequestMapping("api")
public class StatusController {
    @GetMapping
    public StringMessage status() {
        return new StringMessage("server is running");
    }

    @GetMapping("ping")
    public StringMessage ping() {
        return new StringMessage("pong");
    }
}
