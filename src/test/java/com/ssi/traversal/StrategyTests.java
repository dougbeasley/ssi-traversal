package com.ssi.traversal;


import com.ssi.traversal.traversers.BreadthFirstStrategy;
import com.ssi.traversal.traversers.DepthFirstStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrategyTests {


    @Test
    public void testBreadthTraversal() {

        BreadthFirstStrategy strategy = new BreadthFirstStrategy<String>();

        strategy.enter("A");
        strategy.enter("B");
        strategy.enter("C");

        assertEquals("A", strategy.leave());
        assertEquals("B", strategy.leave());
        assertEquals("C", strategy.leave());
    }

    @Test
    public void testDepthFirstTraversal() {

        DepthFirstStrategy strategy = new DepthFirstStrategy<String>();

        strategy.enter("A");
        strategy.enter("B");
        strategy.enter("C");

        assertEquals("C", strategy.leave());
        assertEquals("B", strategy.leave());
        assertEquals("A", strategy.leave());
    }




}
