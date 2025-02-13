package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Tickets;

public interface TicketsRepo extends JpaRepository<Tickets, Long> {
    
    @Query("SELECT t FROM Tickets t WHERE t.responseTxt IS NULL")
    List<Tickets> findByResponseTxtIsNull(); // Pending
    
    @Query("SELECT t FROM Tickets t WHERE t.responseTxt IS NOT NULL")
    List<Tickets> findByResponseTxtIsNotNull(); // Resolved 
    
    @Query("SELECT t.user.userId, t.id AS ticketId, t.title FROM Tickets t")
    List<Object[]> findUserIdTicketIdAndTitle();
    
    
    List<Tickets> findByUserUserIdAndResponseTxtIsNotNull(Long userId);
    
    
}

