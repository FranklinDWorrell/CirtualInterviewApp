package com.fdworrell.interview.converters.impl;

import com.fdworrell.interview.converters.IDateLongConverter;
import com.fdworrell.interview.converters.IMessageConverter;
import com.fdworrell.interview.domains.Message;
import com.fdworrell.interview.views.ViewMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageConverter implements IMessageConverter {

    @Autowired
    IDateLongConverter dateLongConverter;

    @Override
    public Message viewToDomain(ViewMessage viewMessage) {
        Message message = new Message();
        message.setMessageId(viewMessage.getMessageId());
        message.setSender(viewMessage.getSender());
        message.setTimeSent(LocalDateTime.now());
        message.setMessageText(viewMessage.getMessageText());
        return message;
    }

    @Override
    public ViewMessage domainToView(Message message) {
        ViewMessage viewMessage = new ViewMessage();
        viewMessage.setMessageId(message.getMessageId());
        viewMessage.setSender(message.getSender());
        viewMessage.setTimeSent(dateLongConverter.convertLocalDateTimeToLong(message.getTimeSent()));
        viewMessage.setMessageText(message.getMessageText());
        return viewMessage;
    }

}
