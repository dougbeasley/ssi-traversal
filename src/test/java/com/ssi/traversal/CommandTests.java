package com.ssi.traversal;


import com.ssi.traversal.commands.ConfigCommands;
import org.junit.Before;
import org.junit.Test;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CommandTests {


    private JLineShellComponent shell;

    @Before
    public void runBeforeTestMethod() {
        Bootstrap bootstrap = new Bootstrap();
        this.shell = bootstrap.getJLineShellComponent();
    }

    @Test
    public void testTypeConfig() {

        CommandResult cr1 = shell.executeCommand("set type breadth");
        assertEquals(true, cr1.isSuccess());
        assertEquals("Using breadth first traversal", cr1.getResult());

        CommandResult cr2 = shell.executeCommand("set type depth");
        assertEquals(true, cr2.isSuccess());
        assertEquals("Using depth first traversal", cr2.getResult());
    }

    @Test
    public void testDetailConfig() {
        CommandResult cr1 = shell.executeCommand("set detail true");
        assertEquals(true, cr1.isSuccess());
        assertEquals("Using detailed detail for outout", cr1.getResult());

        CommandResult cr2 = shell.executeCommand("set detail false");
        assertEquals(true, cr2.isSuccess());
        assertEquals("Using simple detail for outout", cr2.getResult());
    }

    @Test
    public void testConfigIntegration() {

        ConfigCommands commands = new ConfigCommands();
        commands.setType("breadth");
        assertEquals(ConfigCommands.TraversalType.BREADTH, commands.getType());
        commands.setType("depth");
        assertEquals(ConfigCommands.TraversalType.DEPTH, commands.getType());

        commands.setDetail("true");
        assertEquals(true, commands.getShowDetail());
        assertEquals("detailed", commands.getLevel());

        commands.setDetail("false");
        assertEquals(false, commands.getShowDetail());
        assertEquals("simple", commands.getLevel());
    }

}
