package services;

import exceptions.InvalidGateException;
import models.*;
import repositories.GateRepository;
import repositories.VehicleRepository;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Optional;

//Business Logic
public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, SpotAssignmentStrategy spotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }


    public Ticket generateTicker(
            String vehicleNumber,
            VehicleType vehicleType,
            Long gateId
    ) throws InvalidGateException {
        /***
         * Goal is to get Ticket Object - > Inside Ticket class we have ParkingSpot, Date, Vehicle, Gate and Operator
         *
         * Get Vehicle Object using VehicleTpye and VehicleNumber - Check if already in DB else create obj
         *
         * Get gate object from DB using gateId. If not obj present in DB then throw exception
         *
         * Get operator from gate
         *
         * need to get parkingSpot using strategy
         *
         * NOTE: To get objects from DB can be coded in repo /DAO(Data Access Object)
         */

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

        if(gateOptional.isEmpty())
        {
            throw new InvalidGateException();
        }
        Gate gate = gateOptional.get();
        Operator operator = gate.getOperator();

        Vehicle vehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        if(vehicleOptional.isEmpty())
        {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        }
        else {
            vehicle = vehicleOptional.get();
        }

        ParkingSpot parkingSpot = spotAssignmentStrategy.findSpot();


        return null;
    }
}
