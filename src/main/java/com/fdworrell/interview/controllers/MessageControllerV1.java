package com.fdworrell.interview.controllers;

import com.fdworrell.interview.converters.IDateLongConverter;
import com.fdworrell.interview.converters.IMessageConverter;
import com.fdworrell.interview.domains.Message;
import com.fdworrell.interview.managers.IMessageManager;
import com.fdworrell.interview.views.ViewMessage;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/message")
public class MessageControllerV1 {

    @Autowired
    private IMessageManager messageManager;

    @Autowired
    private IMessageConverter messageConverter;

    @Autowired
    private IDateLongConverter dateLongConverter;

    @ApiOperation(value = "Sends a message to the users specified in the message body")
    @RequestMapping(method = RequestMethod.POST)
    ViewMessage send(@RequestBody ViewMessage viewMessage) {
        Message message = messageConverter.viewToDomain(viewMessage);
        List<String> recipients = viewMessage.getRecipients();
        Message response = messageManager.send(message, recipients);
        return messageConverter.domainToView(response);
    }

    @ApiOperation("Gets all messages for a user since a given date")
    @RequestMapping(value = "/{recipient}/{since}", method = RequestMethod.GET)
    List<ViewMessage> receive(@PathVariable String recipient, @PathVariable Long since) {
        LocalDateTime localDateTime = dateLongConverter.convertLongToLocalDateTime(since);
        return messageManager.receive(recipient, localDateTime).stream()
                .map(messageConverter::domainToView)
                .collect(Collectors.toList());
    }
}
