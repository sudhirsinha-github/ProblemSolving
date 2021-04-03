package workshop;

import org.junit.Test;

public class MatchTest {

    @Test
    public void testplayKnockout() {
        Match.playKnockout(new Over(2), 12, batsman);
    }
}