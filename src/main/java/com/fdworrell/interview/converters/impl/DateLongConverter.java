package com.fdworrell.interview.converters.impl;

import com.fdworrell.interview.converters.IDateLongConverter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class DateLongConverter implements IDateLongConverter {

    @Override
    public LocalDateTime convertLongToLocalDateTime(Long longDate) {
        if (longDate == null) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(longDate), ZoneOffset.UTC);
    }

    @Override
    public Long convertLocalDateTimeToLong(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
    }

}
