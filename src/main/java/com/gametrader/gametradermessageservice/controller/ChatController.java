package com.gametrader.gametradermessageservice.controller;

import com.gametrader.gametradermessageservice.dto.ConversationDto;
import com.gametrader.gametradermessageservice.dto.MessageDto;
import com.gametrader.gametradermessageservice.service.ChatService;
import com.gametrader.gametradermessageservice.service.ChatServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/message")
@AllArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    @PostMapping("/create")
    public ResponseEntity<ConversationDto> createConversation(@RequestBody @NotNull ConversationDto dto) {
        return new ResponseEntity<>(chatService.createConversation(dto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ConversationDto> getConversationById(@PathVariable @NotNull Long id) {
        return new ResponseEntity<>(chatService.getConversationById(id), HttpStatus.OK);
    }

    @MessageMapping("/chat/{conversationId}")
    public void sendMessage(@DestinationVariable Long conversationId, MessageDto dto) {
        messagingTemplate.convertAndSend("/topic/messages/" + conversationId, dto);
        chatService.updateConversation(dto, conversationId);
    }
}
