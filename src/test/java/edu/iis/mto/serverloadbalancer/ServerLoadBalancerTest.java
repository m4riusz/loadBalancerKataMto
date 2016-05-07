package edu.iis.mto.serverloadbalancer;


import org.junit.Test;

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

}
