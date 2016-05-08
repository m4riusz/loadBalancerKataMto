package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusz on 07.05.16.
 */
public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    private double currentLoadPercentage;
    private int capacity;

    private List<Vm> vms = new ArrayList<Vm>();

    public boolean contains(Vm theVm) {
        return vms.contains(theVm);
    }

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public void addVm(Vm vm) {
        this.currentLoadPercentage = this.getCurrentLoadPercentage() + loadOfVm(vm);
        this.vms.add(vm);
    }

    private double loadOfVm(Vm vm) {
        return (double) vm.getSize() / (double) this.getCapacity() * MAXIMUM_LOAD;
    }

    public int countVms() {
        return this.vms.size();
    }

    public boolean canFit(Vm vm) {
        return getCurrentLoadPercentage() + loadOfVm(vm) <= MAXIMUM_LOAD;
    }

    public double getCurrentLoadPercentage() {
        return currentLoadPercentage;
    }

    public int getCapacity() {
        return capacity;
    }
}
