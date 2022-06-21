package com.gametrader.gametradermessageservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametrader.gametradermessageservice.dto.ConversationDto;
import com.gametrader.gametradermessageservice.dto.MessageDto;
import com.gametrader.gametradermessageservice.service.ChatService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ChatController.class, SimpMessagingTemplate.class})
@ExtendWith(SpringExtension.class)
class ChatControllerTest {
    @Autowired
    private ChatController chatController;

    @MockBean
    private ChatService chatService;

    @MockBean
    private MessageChannel messageChannel;

    /**
     * Method under test: {@link ChatController#createConversation(ConversationDto)}
     */
    @Test
    void testCreateConversation() throws Exception {
        when(this.chatService.createConversation((ConversationDto) any())).thenReturn(new ConversationDto());

        ConversationDto conversationDto = new ConversationDto();
        conversationDto.setId(123L);
        conversationDto.setMessage(new ArrayList<>());
        conversationDto.setParticipantId(123L);
        conversationDto.setPostId(123L);
        conversationDto.setPostOwnerId(123L);
        String content = (new ObjectMapper()).writeValueAsString(conversationDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/message/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.chatController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":null,\"postId\":null,\"postOwnerId\":null,\"participantId\":null,\"message\":null}"));
    }

    /**
     * Method under test: {@link ChatController#getConversationById(Long)}
     */
    @Test
    void testGetConversationById() throws Exception {
        when(this.chatService.getConversationById((Long) any())).thenReturn(new ConversationDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/message/get/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.chatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":null,\"postId\":null,\"postOwnerId\":null,\"participantId\":null,\"message\":null}"));
    }

    /**
     * Method under test: {@link ChatController#getConversationById(Long)}
     */
    @Test
    void testGetConversationById2() throws Exception {
        when(this.chatService.getConversationById((Long) any())).thenReturn(new ConversationDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/message/get/{id}", 123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.chatController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":null,\"postId\":null,\"postOwnerId\":null,\"participantId\":null,\"message\":null}"));
    }

    /**
     * Method under test: {@link ChatController#sendMessage(Long, MessageDto)}
     */
    @Test
    void testSendMessage() {
        when(this.messageChannel.send((org.springframework.messaging.Message<Object>) any())).thenReturn(true);
        doNothing().when(this.chatService).updateConversation((MessageDto) any(), (Long) any());
        this.chatController.sendMessage(123L, new MessageDto());
        verify(this.messageChannel).send((org.springframework.messaging.Message<Object>) any());
        verify(this.chatService).updateConversation((MessageDto) any(), (Long) any());
    }

    /**
     * Method under test: {@link ChatController#sendMessage(Long, MessageDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendMessage2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.messaging.MessageDeliveryException: Failed to send message to destination '/topic/messages/123' within timeout: -1
        //       at org.springframework.messaging.simp.SimpMessagingTemplate.sendInternal(SimpMessagingTemplate.java:190)
        //       at org.springframework.messaging.simp.SimpMessagingTemplate.doSend(SimpMessagingTemplate.java:162)
        //       at org.springframework.messaging.simp.SimpMessagingTemplate.doSend(SimpMessagingTemplate.java:48)
        //       at org.springframework.messaging.core.AbstractMessageSendingTemplate.send(AbstractMessageSendingTemplate.java:109)
        //       at org.springframework.messaging.core.AbstractMessageSendingTemplate.convertAndSend(AbstractMessageSendingTemplate.java:151)
        //       at org.springframework.messaging.core.AbstractMessageSendingTemplate.convertAndSend(AbstractMessageSendingTemplate.java:129)
        //       at org.springframework.messaging.core.AbstractMessageSendingTemplate.convertAndSend(AbstractMessageSendingTemplate.java:122)
        //       at com.gametrader.gametradermessageservice.controller.ChatController.sendMessage(ChatController.java:37)
        //   In order to prevent sendMessage(Long, MessageDto)
        //   from throwing MessageDeliveryException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendMessage(Long, MessageDto).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.messageChannel.send((org.springframework.messaging.Message<Object>) any())).thenReturn(false);
        doNothing().when(this.chatService).updateConversation((MessageDto) any(), (Long) any());
        this.chatController.sendMessage(123L, new MessageDto());
    }
}

