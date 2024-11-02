package repositories;

import models.Gate;

import java.util.Optional;

/*Have every method allows to do CRUD operations on gate on DB*/
public class GateRepository implements IGateRepository{

    public Optional<Gate> findGateById(Long gateId)
    {
        return Optional.empty();
    }


}
