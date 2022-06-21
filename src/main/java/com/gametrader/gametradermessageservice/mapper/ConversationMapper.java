package com.gametrader.gametradermessageservice.mapper;

import com.gametrader.gametradermessageservice.dto.ConversationDto;
import com.gametrader.gametradermessageservice.entity.ConversationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversationMapper {

    ConversationDto entityToDto(ConversationEntity entity);

    ConversationEntity dtoToEntity(ConversationDto dto);
}
