package repositories;

import models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*Have every method allows to do CRUD operations on gate on DB*/
public class GateRepository implements IGateRepository{
    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> findGateById(Long gateId)
    {
        if(gates.containsKey(gateId))
        {
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }


}
