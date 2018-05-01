package com.adidas.codingchallenge.common.resourcebundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Class to access a messages
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource);
    }

    /**
     * Gets a message from key
     *
     * @param key The key to get his message
     * @return String with the message
     */
    public String get(String key) {
        return accessor.getMessage(key);
    }
}
