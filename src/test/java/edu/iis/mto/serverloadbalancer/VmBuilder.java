package edu.iis.mto.serverloadbalancer;

/**
 * Created by mariusz on 08.05.16.
 */
public class VmBuilder implements Builder<Vm> {
    private int size;

    public VmBuilder ofSize(int size) {
        this.size = size;
        return this;
    }

    public Vm build() {
        return new Vm(size);
    }

    public static VmBuilder vm() {
        return new VmBuilder();
    }
}
