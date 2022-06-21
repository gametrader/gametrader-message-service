package com.gametrader.gametradermessageservice.service;

import com.gametrader.gametradermessageservice.dto.ConversationDto;
import com.gametrader.gametradermessageservice.dto.MessageDto;

public interface ChatService {
    ConversationDto createConversation(ConversationDto dto);

    ConversationDto getConversationById(Long id);

    void updateConversation(MessageDto dto, Long conversationId);
}
