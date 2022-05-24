package com.gametrader.gametradermessageservice.mapper;

import com.gametrader.gametradermessageservice.dto.MessageDto;
import com.gametrader.gametradermessageservice.entity.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageDto entityToDto(MessageEntity entity);
    MessageEntity dtoToEntity(MessageDto dto);
}
