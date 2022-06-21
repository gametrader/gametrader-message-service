package com.gametrader.gametradermessageservice.dto;


import com.gametrader.gametradermessageservice.entity.MessageEntity;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversationDto {
    @NotNull
    private Long id;
    @NotNull
    private Long postId;
    @NotNull
    private Long postOwnerId;
    @NotNull
    private Long participantId;

    private List<MessageEntity> message;
}
