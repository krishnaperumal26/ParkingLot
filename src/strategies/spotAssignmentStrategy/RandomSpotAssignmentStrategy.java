package strategies.spotAssignmentStrategy;

import models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) {

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloorList())
        {
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots())
            {
                if(parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
                    parkingSpot.getVehicleType().contains(vehicleType))
                {
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }


}
