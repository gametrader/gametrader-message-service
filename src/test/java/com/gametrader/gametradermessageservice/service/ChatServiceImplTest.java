package com.gametrader.gametradermessageservice.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gametrader.gametradermessageservice.dto.ConversationDto;
import com.gametrader.gametradermessageservice.dto.MessageDto;
import com.gametrader.gametradermessageservice.entity.ConversationEntity;
import com.gametrader.gametradermessageservice.entity.MessageEntity;
import com.gametrader.gametradermessageservice.mapper.ConversationMapper;
import com.gametrader.gametradermessageservice.mapper.MessageMapper;
import com.gametrader.gametradermessageservice.repository.ConversationRepository;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChatServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ChatServiceImplTest {
    @Autowired
    private ChatServiceImpl chatServiceImpl;

    @MockBean
    private ConversationMapper conversationMapper;

    @MockBean
    private ConversationRepository conversationRepository;

    @MockBean
    private MessageMapper messageMapper;

    /**
     * Method under test: {@link ChatServiceImpl#createConversation(ConversationDto)}
     */
    @Test
    void testCreateConversation() {
        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        when(this.conversationRepository.saveAndFlush((ConversationEntity) any())).thenReturn(conversationEntity);

        ConversationEntity conversationEntity1 = new ConversationEntity();
        conversationEntity1.setId(123L);
        conversationEntity1.setMessage(new ArrayList<>());
        conversationEntity1.setParticipantId(123L);
        conversationEntity1.setPostId(123L);
        conversationEntity1.setPostOwnerId(123L);
        ConversationDto conversationDto = new ConversationDto();
        when(this.conversationMapper.entityToDto((ConversationEntity) any())).thenReturn(conversationDto);
        when(this.conversationMapper.dtoToEntity((ConversationDto) any())).thenReturn(conversationEntity1);
        assertSame(conversationDto, this.chatServiceImpl.createConversation(new ConversationDto()));
        verify(this.conversationRepository).saveAndFlush((ConversationEntity) any());
        verify(this.conversationMapper).entityToDto((ConversationEntity) any());
        verify(this.conversationMapper).dtoToEntity((ConversationDto) any());
    }

    /**
     * Method under test: {@link ChatServiceImpl#createConversation(ConversationDto)}
     */
    @Test
    void testCreateConversation2() {
        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        when(this.conversationRepository.saveAndFlush((ConversationEntity) any())).thenReturn(conversationEntity);
        when(this.conversationMapper.entityToDto((ConversationEntity) any())).thenThrow(new NoSuchElementException("foo"));
        when(this.conversationMapper.dtoToEntity((ConversationDto) any())).thenThrow(new NoSuchElementException("foo"));
        assertThrows(NoSuchElementException.class, () -> this.chatServiceImpl.createConversation(new ConversationDto()));
        verify(this.conversationMapper).dtoToEntity((ConversationDto) any());
    }

    /**
     * Method under test: {@link ChatServiceImpl#getConversationById(Long)}
     */
    @Test
    void testGetConversationById() {
        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        Optional<ConversationEntity> ofResult = Optional.of(conversationEntity);
        when(this.conversationRepository.findById((Long) any())).thenReturn(ofResult);
        ConversationDto conversationDto = new ConversationDto();
        when(this.conversationMapper.entityToDto((ConversationEntity) any())).thenReturn(conversationDto);
        assertSame(conversationDto, this.chatServiceImpl.getConversationById(123L));
        verify(this.conversationRepository).findById((Long) any());
        verify(this.conversationMapper).entityToDto((ConversationEntity) any());
    }

    /**
     * Method under test: {@link ChatServiceImpl#getConversationById(Long)}
     */
    @Test
    void testGetConversationById2() {
        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        Optional<ConversationEntity> ofResult = Optional.of(conversationEntity);
        when(this.conversationRepository.findById((Long) any())).thenReturn(ofResult);
        when(this.conversationMapper.entityToDto((ConversationEntity) any())).thenThrow(new NoSuchElementException("foo"));
        assertThrows(NoSuchElementException.class, () -> this.chatServiceImpl.getConversationById(123L));
        verify(this.conversationRepository).findById((Long) any());
        verify(this.conversationMapper).entityToDto((ConversationEntity) any());
    }

    /**
     * Method under test: {@link ChatServiceImpl#getConversationById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetConversationById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException
        //       at java.util.Optional.orElseThrow(Optional.java:408)
        //       at com.gametrader.gametradermessageservice.service.ChatServiceImpl.getConversationById(ChatServiceImpl.java:30)
        //   In order to prevent getConversationById(Long)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getConversationById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.conversationRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(this.conversationMapper.entityToDto((ConversationEntity) any())).thenReturn(new ConversationDto());
        this.chatServiceImpl.getConversationById(123L);
    }

    /**
     * Method under test: {@link ChatServiceImpl#updateConversation(MessageDto, Long)}
     */
    @Test
    void testUpdateConversation() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setAuthorId(123L);
        messageEntity.setContent("Not all who wander are lost");
        messageEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        messageEntity.setId(123L);
        messageEntity.setIsDisplayed(true);
        when(this.messageMapper.dtoToEntity((MessageDto) any())).thenReturn(messageEntity);

        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        Optional<ConversationEntity> ofResult = Optional.of(conversationEntity);

        ConversationEntity conversationEntity1 = new ConversationEntity();
        conversationEntity1.setId(123L);
        conversationEntity1.setMessage(new ArrayList<>());
        conversationEntity1.setParticipantId(123L);
        conversationEntity1.setPostId(123L);
        conversationEntity1.setPostOwnerId(123L);
        when(this.conversationRepository.save((ConversationEntity) any())).thenReturn(conversationEntity1);
        when(this.conversationRepository.findById((Long) any())).thenReturn(ofResult);
        this.chatServiceImpl.updateConversation(new MessageDto(), 123L);
        verify(this.messageMapper).dtoToEntity((MessageDto) any());
        verify(this.conversationRepository).save((ConversationEntity) any());
        verify(this.conversationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ChatServiceImpl#updateConversation(MessageDto, Long)}
     */
    @Test
    void testUpdateConversation2() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setAuthorId(123L);
        messageEntity.setContent("Not all who wander are lost");
        messageEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        messageEntity.setId(123L);
        messageEntity.setIsDisplayed(true);
        when(this.messageMapper.dtoToEntity((MessageDto) any())).thenReturn(messageEntity);

        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        Optional<ConversationEntity> ofResult = Optional.of(conversationEntity);
        when(this.conversationRepository.save((ConversationEntity) any())).thenThrow(new NoSuchElementException("foo"));
        when(this.conversationRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NoSuchElementException.class, () -> this.chatServiceImpl.updateConversation(new MessageDto(), 123L));
        verify(this.messageMapper).dtoToEntity((MessageDto) any());
        verify(this.conversationRepository).save((ConversationEntity) any());
        verify(this.conversationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ChatServiceImpl#updateConversation(MessageDto, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateConversation3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException
        //       at java.util.Optional.orElseThrow(Optional.java:408)
        //       at com.gametrader.gametradermessageservice.service.ChatServiceImpl.updateConversation(ChatServiceImpl.java:36)
        //   In order to prevent updateConversation(MessageDto, Long)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateConversation(MessageDto, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setAuthorId(123L);
        messageEntity.setContent("Not all who wander are lost");
        messageEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        messageEntity.setId(123L);
        messageEntity.setIsDisplayed(true);
        when(this.messageMapper.dtoToEntity((MessageDto) any())).thenReturn(messageEntity);

        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId(123L);
        conversationEntity.setMessage(new ArrayList<>());
        conversationEntity.setParticipantId(123L);
        conversationEntity.setPostId(123L);
        conversationEntity.setPostOwnerId(123L);
        when(this.conversationRepository.save((ConversationEntity) any())).thenReturn(conversationEntity);
        when(this.conversationRepository.findById((Long) any())).thenReturn(Optional.empty());
        this.chatServiceImpl.updateConversation(new MessageDto(), 123L);
    }
}

