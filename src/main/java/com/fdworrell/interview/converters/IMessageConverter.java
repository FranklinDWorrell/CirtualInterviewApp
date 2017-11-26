package com.fdworrell.interview.converters;

import com.fdworrell.interview.domains.Message;
import com.fdworrell.interview.views.ViewMessage;

public interface IMessageConverter {

    Message viewToDomain(ViewMessage viewMessage);

    ViewMessage domainToView(Message message);

}
