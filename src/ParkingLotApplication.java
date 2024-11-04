import controllers.TicketController;
import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Optional;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssignmentStrategy,
                ticketRepository,
                parkingLotRepository
        );

        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Application Started..");
    }
}