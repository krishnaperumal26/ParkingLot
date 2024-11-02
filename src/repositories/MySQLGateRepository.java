package repositories;

import models.Gate;

import java.util.Optional;

public class MySQLGateRepository implements IGateRepository{
    @Override
    public Optional<Gate> findGateById(Long gateId) {
        return Optional.empty();
    }
}
