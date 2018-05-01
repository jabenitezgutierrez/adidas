package com.adidas.codingchallenge.common.resourcebundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * CommonRestClient test class
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MessagesTest {

    @InjectMocks
    private Messages messages;

    @Mock
    private MessageSource messageSource;

    @Mock
    private MessageSourceAccessor accessor;

    @Test
    public void whenGetKeyWithoutErrors() {
        // Assert
        final String key = "key";
        final String keyMessage = "message";

        when(accessor.getMessage(key)).thenReturn(keyMessage);

        // Act
        String keyMessageRet = this.messages.get(key);

        // Arrange
        assertEquals(keyMessageRet, keyMessage);
    }

}
