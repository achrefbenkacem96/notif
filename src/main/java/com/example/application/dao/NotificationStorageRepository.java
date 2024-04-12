package com.example.application.dao;

import com.example.application.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationStorageRepository extends JpaRepository<Notification, String> {

    Optional<Notification> findById(String id);

    List<Notification> findByUserToId(String id);


    List<Notification> findByUserToIdAndDeliveredFalse(String id);


}