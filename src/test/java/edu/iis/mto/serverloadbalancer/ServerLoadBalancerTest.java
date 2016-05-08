package edu.iis.mto.serverloadbalancer;


import org.hamcrest.Matcher;
import org.junit.Test;

import static edu.iis.mto.serverloadbalancer.CurrentLoadPercentageMatcher.hasCurrentLoadOf;
import static edu.iis.mto.serverloadbalancer.ServerBuilder.server;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ServerLoadBalancerTest {
    @Test
    public void itCompiles() {
        assertThat(true, equalTo(true));
    }

    @Test
    public void balancingServerWithNoVms_serverStaysEmpty() {
        Server server = a(server().withCapacity(1));
        balancing(aServerWith(server), anEmptyListOfVms());
        assertThat(server, hasCurrentLoadOf(0.0d));
    }

    @Test
    public void balancingOneServerWithOneSlotCapacity_andOneSlotVm_fillsServerWithTheVm(){
        Server server = a(server().withCapacity(1));
        Vm theVm = a(vm(), ofSize(1));
        balancing(aServerWith(server), anEmptyListOfVms());
        assertThat(server, hasCurrentLoadOf(100.0d));
    }

    private void balancing(Server[] servers, Vm[] vms) {
        new ServerLoadBalancer().balance(servers,vms);
    }

    private Vm[] anEmptyListOfVms() {
        return new Vm[0];
    }

    private Server[] aServerWith(Server... servers) {
        return servers;
    }

    public Server a(ServerBuilder serverBuilder){
        return serverBuilder.build();
    }

}
