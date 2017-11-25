package com.fdworrell.interview.managers;

import com.fdworrell.interview.domains.Message;
import com.fdworrell.interview.domains.MessageRecipient;

import java.time.LocalDateTime;
import java.util.List;

public interface IMessageManager {

    Message send(Message message, List<MessageRecipient> recipients);

    List<Message> receive(String recipient, LocalDateTime timeSent);

}
