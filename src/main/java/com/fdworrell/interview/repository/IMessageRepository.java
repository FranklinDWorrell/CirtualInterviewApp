package com.fdworrell.interview.repository;

import com.fdworrell.interview.domains.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IMessageRepository extends JpaRepository<Message, Long> {
    Message findByMessageIdAndTimeSentAfter(Long messageId, LocalDateTime timeSent);
}
