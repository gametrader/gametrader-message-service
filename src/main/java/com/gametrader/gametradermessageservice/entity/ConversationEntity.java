package com.gametrader.gametradermessageservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "conversation")
public class ConversationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "post_owner_id", nullable = false)
    private Long postOwnerId;

    @Column(name = "participant_id", nullable = false)
    private Long participantId;

    @Column(name = "message", nullable = true)
    @OneToMany
    private List<MessageEntity> message;
}
