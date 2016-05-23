package edu.iis.mto.serverloadbalancer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static edu.iis.mto.serverloadbalancer.CurrentLoadPercentageMatcher.hasLoadPercentageOf;
import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static edu.iis.mto.serverloadbalancer.VmBuilder.vm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ServerLoadBalancerParametrizedTest extends ServerLoadBalancerBaseTest {

    private int serverCapacity;
    private int vmSize;
    private double percentageLoad;

    public ServerLoadBalancerParametrizedTest(int serverCapacity, int vmSize, double percentageLoad) {
        this.serverCapacity = serverCapacity;
        this.vmSize = vmSize;
        this.percentageLoad = percentageLoad;
    }

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 1, 10.0d}, {4, 2, 50.0d}, {5, 2, 40.0d}, {7, 3, 42.85d}
        });
    }

    @Test
    public void balancingOneServerWithOneSlotCapacity_andOneSlotVm_fillsTheServerWithTheVm() {
        Server theServer = a(server().withCapacity(serverCapacity));
        Vm theVm = a(vm().ofSize(vmSize));
        balance(aListOfServersWith(theServer), aListOfVmsWith(theVm));

        assertThat(theServer, hasLoadPercentageOf(percentageLoad));
        assertThat("the server should contain vm", theServer.contains(theVm));
    }


}
