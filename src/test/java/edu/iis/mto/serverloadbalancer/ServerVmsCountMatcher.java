package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by mariusz on 08.05.16.
 */
public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {

    private final int expectedCount;

    public ServerVmsCountMatcher(int expectedCount) {
        this.expectedCount = expectedCount;
    }

    protected boolean matchesSafely(Server server) {
        return expectedCount == server.countVms();
    }

    public void describeTo(Description description) {
        description.appendText("a server with vms count of ").appendValue(expectedCount);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description mismatchDescription) {
        mismatchDescription.appendText("a server with vms count of ").appendValue(item.countVms());
    }


    public static ServerVmsCountMatcher hasAVmCountOf(int expectedCount) {
        return new ServerVmsCountMatcher(expectedCount);
    }
}
