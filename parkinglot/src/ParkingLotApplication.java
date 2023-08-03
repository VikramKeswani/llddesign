import controller.TicketController;
import repositeries.GateRepository;
import repositeries.ParkingLotRepository;
import repositeries.TicketRepository;
import repositeries.VehicleRepository;
import service.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();

        TicketService ticketService = new TicketService(gateRepository,vehicleRepository,parkingLotRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

    }
}