package core.mate.academy.service;

import java.util.List;


public interface MachineService <Machine> {

    List<Machine> getAll(Class <? extends Machine> type);

    <T> void fill(List<? super T> machines, T value);

    void startWorking(List<? extends Machine> machines);
}
