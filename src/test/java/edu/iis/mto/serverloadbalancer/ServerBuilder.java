package edu.iis.mto.serverloadbalancer;

/**
 * Created by mariusz on 07.05.16.
 */
public class ServerBuilder implements Builder<Server> {

    private int capacity;

    public Server build() {
        return new Server();
    }

    public ServerBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public static ServerBuilder server() {
        return new ServerBuilder();
    }
}
