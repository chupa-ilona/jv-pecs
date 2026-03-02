package core.mate.academy.service;

import core.mate.academy.model.Excavator;

import java.util.List;

public class ExcavatorProducer implements MachineProducer<Excavator> {

    @Override
    public List<Excavator> get() {
        Excavator excavator = new Excavator();
        Excavator excavator2 = new Excavator();
        Excavator excavator3 = new Excavator();
        return List.of(excavator, excavator2, excavator3);
    }
}
