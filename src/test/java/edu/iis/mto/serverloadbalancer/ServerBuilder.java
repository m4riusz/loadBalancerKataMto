package edu.iis.mto.serverloadbalancer;

/**
 * Created by mariusz on 07.05.16.
 */
public class ServerBuilder {

    private int capacity;

    public Server build() {
        return new Server();
    }

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }
}
