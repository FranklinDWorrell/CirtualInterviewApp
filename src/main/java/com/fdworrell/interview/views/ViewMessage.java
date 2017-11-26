package com.fdworrell.interview.views;

import java.util.List;

public class ViewMessage {

    private Long messageId;

    private String sender;

    private Long timeSent;

    private String messageText;

    private List<String> recipients;

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

    public Long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Long timeSent) {
        this.timeSent = timeSent;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewMessage that = (ViewMessage) o;

        if (!messageId.equals(that.messageId)) return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;
        if (timeSent != null ? !timeSent.equals(that.timeSent) : that.timeSent != null) return false;
        return messageText != null ? messageText.equals(that.messageText) : that.messageText == null;
    }

    @Override
    public int hashCode() {
        int result = messageId.hashCode();
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (timeSent != null ? timeSent.hashCode() : 0);
        result = 31 * result + (messageText != null ? messageText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ViewMessage{" +
                "messageId=" + messageId +
                ", sender='" + sender + '\'' +
                ", timeSent=" + timeSent +
                ", messageText='" + messageText + '\'' +
                ", recipients=" + recipients +
                '}';
    }

}
