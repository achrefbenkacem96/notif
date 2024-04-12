package com.example.application.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Notification {

    @Id
    private String id;

    private String content;

    private Utilisateur userTo;

    private Utilisateur userFrom;

    private NotificationType notificationType;

    private boolean delivered;
    private boolean read;

}