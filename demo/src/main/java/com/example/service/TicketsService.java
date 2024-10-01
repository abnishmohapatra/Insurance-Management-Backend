package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Tickets;
import com.example.repo.TicketsRepo;

@Service
public class TicketsService {

    private final TicketsRepo ticketsRepo;

    public TicketsService(TicketsRepo ticketsRepo) {
        this.ticketsRepo = ticketsRepo;
    }

    
    public List<Tickets> getAllTickets() {
        return ticketsRepo.findAll();
    }

   
    public List<Tickets> getOpenTickets() {
        return ticketsRepo.findByResponseTxtIsNull();
    }

   
    public List<Tickets> getCloseTickets() {
        return ticketsRepo.findByResponseTxtIsNotNull();
    }

    
    public Optional<Tickets> getTicketById(Long id) {
        return ticketsRepo.findById(id);
    }

    
    public long getTotalTickets() {
        return ticketsRepo.count();
    }

   
    public void add(@RequestBody Tickets ticket) {
        ticketsRepo.save(ticket);
    }

    
    public void updateTicket(Long id, Tickets ticketDetails) {
        Optional<Tickets> ticketOptional = ticketsRepo.findById(id);
        Tickets ticket = ticketOptional.orElseThrow(() -> new IllegalArgumentException("Invalid ticket ID"));
        ticket.setResponseTxt(ticketDetails.getResponseTxt());
        ticketsRepo.save(ticket);
    }
    
 
    public List<Tickets> getSolvedTicketsForUser(Long userId) {
        return ticketsRepo.findByUserUserIdAndResponseTxtIsNotNull(userId);
    }
    
    
    
} 
