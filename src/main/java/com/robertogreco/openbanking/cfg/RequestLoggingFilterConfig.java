package com.robertogreco.openbanking.cfg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

//@Configuration
public class RequestLoggingFilterConfig {

    //@Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(100000);
        filter.setIncludeHeaders(true);
        filter.setBeforeMessagePrefix("BEFORE REQUEST DATA : ");
        filter.setAfterMessagePrefix("AFTER REQUEST DATA : ");
        return filter;
    }



}