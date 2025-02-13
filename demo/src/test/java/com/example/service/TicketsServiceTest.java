package com.example.service;

import com.example.model.Tickets;
import com.example.repo.TicketsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TicketsServiceTest {

    @Mock
    private TicketsRepo ticketsRepo;

    @InjectMocks
    private TicketsService ticketsService;

    private Tickets ticket1;
    private Tickets ticket2;

    @BeforeEach
    void setUp() {
        ticket1 = new Tickets();
        ticket1.setId(1L);
        ticket1.setTitle("Ticket 1");

        ticket2 = new Tickets();
        ticket2.setId(2L);
        ticket2.setTitle("Ticket 2");
    }

    @Test
    void testGetAllTickets() {
        when(ticketsRepo.findAll()).thenReturn(Arrays.asList(ticket1, ticket2));

        List<Tickets> result = ticketsService.getAllTickets();

        assertEquals(2, result.size());
        assertEquals(ticket1, result.get(0));
        assertEquals(ticket2, result.get(1));
        verify(ticketsRepo, times(1)).findAll();
    }

    @Test
    void testGetOpenTickets() {
        when(ticketsRepo.findByResponseTxtIsNull()).thenReturn(Arrays.asList(ticket1));

        List<Tickets> result = ticketsService.getOpenTickets();

        assertEquals(1, result.size());
        assertEquals(ticket1, result.get(0));
        verify(ticketsRepo, times(1)).findByResponseTxtIsNull();
    }

    @Test
    void testGetCloseTickets() {
        when(ticketsRepo.findByResponseTxtIsNotNull()).thenReturn(Arrays.asList(ticket2));

        List<Tickets> result = ticketsService.getCloseTickets();

        assertEquals(1, result.size());
        assertEquals(ticket2, result.get(0));
        verify(ticketsRepo, times(1)).findByResponseTxtIsNotNull();
    }

    @Test
    void testGetTicketById_Found() {
        when(ticketsRepo.findById(anyLong())).thenReturn(Optional.of(ticket1));

        Optional<Tickets> result = ticketsService.getTicketById(1L);

        assertTrue(result.isPresent());
        assertEquals(ticket1, result.get());
        verify(ticketsRepo, times(1)).findById(1L);
    }

    @Test
    void testGetTicketById_NotFound() {
        when(ticketsRepo.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Tickets> result = ticketsService.getTicketById(1L);

        assertTrue(result.isEmpty());
        verify(ticketsRepo, times(1)).findById(1L);
    }

    @Test
    void testGetTotalTickets() {
        when(ticketsRepo.count()).thenReturn(2L);

        long result = ticketsService.getTotalTickets();

        assertEquals(2L, result);
        verify(ticketsRepo, times(1)).count();
    }



    @Test
    void testUpdateTicket() {
        when(ticketsRepo.findById(anyLong())).thenReturn(Optional.of(ticket1));
        when(ticketsRepo.save(any(Tickets.class))).thenReturn(ticket1);

        Tickets updatedTicket = new Tickets();
        updatedTicket.setResponseTxt("Response text");

        ticketsService.updateTicket(1L, updatedTicket);

        assertEquals("Response text", ticket1.getResponseTxt());
        verify(ticketsRepo, times(1)).findById(1L);
        verify(ticketsRepo, times(1)).save(ticket1);
    }
    
    @Test
    void testAddTicket() {
        Tickets ticket1 = new Tickets(); 

         when(ticketsRepo.save(any(Tickets.class))).thenReturn(ticket1);

         ticketsService.add(ticket1);

        verify(ticketsRepo, times(1)).save(ticket1);
    }
}

