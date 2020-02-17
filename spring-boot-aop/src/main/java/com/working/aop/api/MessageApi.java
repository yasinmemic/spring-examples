package com.working.aop.api;

import com.working.aop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;

    @PostMapping("/{message}")
    public ResponseEntity<String> getAll(@PathVariable("message") String message) {
        return ResponseEntity.ok(messageService.getMessage(message));
    }
}
