package com.gametrader.gametradermessageservice.repository;

import com.gametrader.gametradermessageservice.entity.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<ConversationEntity, Long> {
}
