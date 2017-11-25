package com.fdworrell.interview.repository;

import com.fdworrell.interview.domains.MessageRecipient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRecipientRepository extends JpaRepository<MessageRecipient, Long> {
    List<MessageRecipient> findAllByRecipient(String recipient);
}
