package repositeries;

import models.Ticket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {

    Map<Long, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket save(Ticket ticket) {
        ticket.setCreatedAt(new Date());
        ticket.setUpdatedAt(new Date());
        ticketMap.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketInfo(Long ticketId) {
        if (ticketMap.containsKey(ticketId))
            return Optional.of(ticketMap.get(ticketId));

        return Optional.empty();
    }
}
