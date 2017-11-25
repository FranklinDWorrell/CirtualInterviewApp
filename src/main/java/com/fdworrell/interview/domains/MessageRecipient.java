package com.fdworrell.interview.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_recipients")
public class MessageRecipient {

    @Id
    @Column(name = "ms_recip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageRecipientId;

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "recipient")
    private String recipient;

    public Long getMessageRecipientId() {
        return messageRecipientId;
    }

    public void setMessageRecipientId(Long messageRecipientId) {
        this.messageRecipientId = messageRecipientId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageRecipient that = (MessageRecipient) o;

        if (!messageRecipientId.equals(that.messageRecipientId)) return false;
        if (!messageId.equals(that.messageId)) return false;
        return recipient.equals(that.recipient);
    }

    @Override
    public int hashCode() {
        int result = messageRecipientId.hashCode();
        result = 31 * result + messageId.hashCode();
        result = 31 * result + recipient.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MessageRecipient{" +
                "messageRecipientId=" + messageRecipientId +
                ", messageId=" + messageId +
                ", recipient='" + recipient + '\'' +
                '}';
    }

}
