package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusz on 07.05.16.
 */
public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public void addVm(Vm vm) {
        this.currentLoadPercentage = (double) vm.size / (double) this.capacity * MAXIMUM_LOAD;
        this.vms.add(vm);
    }

    public int countVms() {
        return this.vms.size();
    }
}
