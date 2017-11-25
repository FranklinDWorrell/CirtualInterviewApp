package com.fdworrell.interview.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(name = "sender")
    private String sender;

    @Column(name = "time_sent")
    private LocalDateTime timeSent;

    @Column(name = "message_text")
    private String messageText;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!messageId.equals(message.messageId)) return false;
        if (!sender.equals(message.sender)) return false;
        if (!timeSent.equals(message.timeSent)) return false;
        return messageText.equals(message.messageText);
    }

    @Override
    public int hashCode() {
        int result = messageId.hashCode();
        result = 31 * result + sender.hashCode();
        result = 31 * result + timeSent.hashCode();
        result = 31 * result + messageText.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sender='" + sender + '\'' +
                ", timeSent=" + timeSent +
                ", messageText='" + messageText + '\'' +
                '}';
    }

}
