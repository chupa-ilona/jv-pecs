package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public <T extends Machine> List<T> getAll(Class<? extends Machine> type) {
        if (type.equals(Bulldozer.class)) {
            return (List<T>) new BulldozerProducer().get();
        }
        if (type.equals(Truck.class)) {
            return (List<T>) new TruckProducer().get();
        }
        if (type.equals(Excavator.class)) {
            return (List<T>) new ExcavatorProducer().get();
        }
        throw new IllegalArgumentException("Unknown machine type: " + type.getName());
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
