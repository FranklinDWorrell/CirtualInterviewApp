package com.fdworrell.interview.converters;

import java.time.LocalDateTime;

public interface IDateLongConverter {

    LocalDateTime convertLongToLocalDateTime(Long longDate);

    Long convertLocalDateTimeToLong(LocalDateTime localDateTime);

}
