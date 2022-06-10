package com.gametrader.gametradermessageservice.service;

import com.gametrader.gametradermessageservice.dto.ConversationDto;
import com.gametrader.gametradermessageservice.dto.MessageDto;
import com.gametrader.gametradermessageservice.entity.ConversationEntity;
import com.gametrader.gametradermessageservice.mapper.ConversationMapper;
import com.gametrader.gametradermessageservice.mapper.MessageMapper;
import com.gametrader.gametradermessageservice.repository.ConversationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ConversationRepository repository;
    private final ConversationMapper conversationMapper;
    private final MessageMapper messageMapper;
    @Override
    public ConversationDto createConversation(ConversationDto dto) {
        ConversationEntity conversationEntity = conversationMapper.dtoToEntity(dto);
        ConversationEntity saved = repository.saveAndFlush(conversationEntity);
        return conversationMapper.entityToDto(saved);
    }

    @Override
    public ConversationDto getConversationById(Long id) {
        ConversationEntity conversationEntity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return conversationMapper.entityToDto(conversationEntity);
    }

    @Override
    public void updateConversation(MessageDto dto, Long conversationId) {
        ConversationEntity conversationEntity = repository.findById(conversationId).orElseThrow(NoSuchElementException::new);
        conversationEntity.getMessage().add(messageMapper.dtoToEntity(dto));
        repository.save(conversationEntity);
    }
}
