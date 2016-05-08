package edu.iis.mto.serverloadbalancer;

/**
 * Created by mariusz on 07.05.16.
 */
public class ServerBuilder implements Builder<Server> {

    private int capacity;
    private double initialLoad;

    public Server build() {
        Server server = new Server(capacity);
        if (initialLoad > 0) {
            int initialVmSize = (int) (initialLoad / (double) capacity * 100.0d);
            Vm initialVm = VmBuilder.vm().ofSize(initialVmSize).build();
            server.addVm(initialVm);
        }
        return server;
    }

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }

    public ServerBuilder withCurrentLoadOf(double initialLoad) {
        this.initialLoad = initialLoad;
        return this;
    }
}
