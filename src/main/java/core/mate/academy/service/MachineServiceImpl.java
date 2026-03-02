package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type.equals(Bulldozer.class)) {
            return new ArrayList<>(new BulldozerProducer().get());
        }
        if (type.equals(Truck.class)) {
            return new ArrayList<>(new TruckProducer().get());
        }
        if (type.equals(Excavator.class)) {
            return new ArrayList<>(new ExcavatorProducer().get());
        }
        return List.of();
    }

    @Override
    public <T> void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
