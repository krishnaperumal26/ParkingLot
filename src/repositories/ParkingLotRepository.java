package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

//    public Optional<ParkingLot> getParkingLotOfGate(Gate gate)
    public ParkingLot getParkingLotOfGate(Gate gate)
    {
        for(ParkingLot parkingLot : parkingLots.values())
        {
            if (parkingLot.getGates().contains(gate))
            {
//                return Optional.of(parkingLot);
                return parkingLot;
            }
        }
//        return Optional.empty();
        return null;
    }

}
