package com.fdworrell.interview.managers.impl;

import com.fdworrell.interview.domains.Message;
import com.fdworrell.interview.domains.MessageRecipient;
import com.fdworrell.interview.managers.IMessageManager;
import com.fdworrell.interview.repository.IMessageRecipientRepository;
import com.fdworrell.interview.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageManager implements IMessageManager {

    @Autowired
    private IMessageRepository messageRepository;

    @Autowired
    private IMessageRecipientRepository messageRecipientRepository;

    @Override
    public Message send(Message message, List<MessageRecipient> recipients) {
        messageRecipientRepository.save(recipients);
        return messageRepository.save(message);
    }

    @Override
    public List<Message> receive(String recipient, LocalDateTime timeSent) {
        List<Message> results = new ArrayList<Message>();
        List<MessageRecipient> msgRecips = messageRecipientRepository.findAllByRecipient(recipient);
        for (MessageRecipient msgRecip : msgRecips) {
            Long messageId = msgRecip.getMessageId();
            Message received = messageRepository.findByMessageIdAndTimeSentAfter(messageId, timeSent);
            if (received != null) {
                results.add(received);
            }
        }
        return results;
    }

}
