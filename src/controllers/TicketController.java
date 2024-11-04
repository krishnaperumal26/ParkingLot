package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import dtos.ResponseStatus;
import exceptions.InvalidGateException;
import exceptions.NoAvailableParkingSpotException;
import models.Ticket;
import models.VehicleType;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) throws InvalidGateException {
        String vehicleNumber = request.getVehicleNumber();
        VehicleType vehicleType = request.getVehicleType();
        Long gateId = request.getGateId();

        Ticket ticket = new Ticket();
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();
        try
        {
            ticket = ticketService.generateTicker(vehicleNumber, vehicleType, gateId);
        }
        catch (InvalidGateException e)
        {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Gate Id is Invalid");
            return response;
        }
//        catch (NoAvailableParkingSpotException e)
//        {
//            response.setResponseStatus(ResponseStatus.SUCCESS);
//            response.setMessage("No Parking Spot available");
//            return response;
//        }

        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setOperatorName(ticket.getOperator().getName());
        response.setTicketId(ticket.getId());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());

        return response;
    }

}
