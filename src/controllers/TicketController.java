package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import dtos.ResponseStatus;
import exceptions.InvalidGateException;
import models.Ticket;
import models.VehicleType;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) throws InvalidGateException {
        String vehicleNumber = request.getVehicleNumber();
        VehicleType vehicleType = request.getVehicleType();
        Long gateId = request.getGateId();

        Ticket ticket = ticketService.generateTicker(vehicleNumber, vehicleType, gateId);

        GenerateTicketResponseDto response = new GenerateTicketResponseDto();
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setOperatorName(ticket.getOperator().getName());
        response.setTicketId(ticket.getId());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());

        return response;
    }

}
