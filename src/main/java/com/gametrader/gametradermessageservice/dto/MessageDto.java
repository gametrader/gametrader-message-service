package com.gametrader.gametradermessageservice.dto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDto {
    @NotNull
    private Long id;
    @NotNull
    private Long authorId;
    @NotNull
    private String content;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Boolean isDisplayed;
}
