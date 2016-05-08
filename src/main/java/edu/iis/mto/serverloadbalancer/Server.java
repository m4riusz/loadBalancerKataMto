package edu.iis.mto.serverloadbalancer;

/**
 * Created by mariusz on 07.05.16.
 */
public class Server {
    public static final double MAXIMUM_LOAD = 100.0d;
    public double currentLoadPercentage;
    public int capacity;

    public boolean contains(Vm theVm) {
        return true;
    }

    public Server(int capacity) {
        this.capacity = capacity;
    }

    public void addVm(Vm vm) {
        this.currentLoadPercentage = (double) vm.size / (double) this.capacity *  MAXIMUM_LOAD;


    }
}
