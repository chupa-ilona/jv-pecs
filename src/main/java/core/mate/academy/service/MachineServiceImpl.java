package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        List<? extends Machine> result = null;
        if (type == Bulldozer.class) {
            BulldozerProducer producer = new BulldozerProducer();
            result = producer.get();
        }

        if (type == Truck.class) {
            TruckProducer producer = new TruckProducer();
            result = producer.get();
        }

        if (type == Excavator.class) {
            ExcavatorProducer producer = new ExcavatorProducer();
            result = producer.get();
        }
        if (result == null) {
            return List.of();
        }
        return (List<Machine>) result;
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