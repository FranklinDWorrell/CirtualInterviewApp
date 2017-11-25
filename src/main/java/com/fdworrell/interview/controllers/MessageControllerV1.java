package com.fdworrell.interview.controllers;

import com.fdworrell.interview.domains.Message;
import com.fdworrell.interview.domains.MessageRecipient;
import com.fdworrell.interview.managers.IMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/message")
public class MessageControllerV1 {

    @Autowired
    private IMessageManager messageManager;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Message> send(Message message, List<MessageRecipient> recipients) {
        Message response = messageManager.send(message, recipients);
        return new ResponseEntity<Message>(response, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Message> receive(String recipient, LocalDateTime since) {
        return messageManager.receive(recipient, since);
    }
}
