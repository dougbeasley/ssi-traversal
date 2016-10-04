package com.ssi.traversal.commands;

import com.ssi.traversal.reporters.DetailReporter;
import com.ssi.traversal.reporters.Reporter;
import com.ssi.traversal.reporters.SimpleReporter;
import com.ssi.traversal.traversers.BreadthFirstStrategy;
import com.ssi.traversal.traversers.DepthFirstStrategy;
import com.ssi.traversal.traversers.DirectoryTraverser;
import com.ssi.traversal.traversers.TraverseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class TraversalCommands implements CommandMarker {


    private final ConfigCommands configCommands;

    @Autowired
    public TraversalCommands(ConfigCommands configCommands) {
        this.configCommands = configCommands;
    }


    @CliAvailabilityIndicator({"traverse"})
    public boolean isTraverseAvailable() {
        //always available
        return true;
    }

    @CliCommand(value = "traverse", help = "Traverse a specified path")
    public String traverse(
            @CliOption(key = "",
                    help = "Traverse a path",
                    unspecifiedDefaultValue = ".") final String path,
            @CliOption(key = "breadth",
                    help = "The traversal type to use",
                    specifiedDefaultValue = "breadth",
                    unspecifiedDefaultValue = "depth") final String type,
            @CliOption(key = "detail",
                    help = "Show file details",
                    specifiedDefaultValue = "true",
                    unspecifiedDefaultValue = "false") final String showDetail) throws FileNotFoundException {

        //TODO add --output to send output to a file
        PrintWriter pw = new PrintWriter(System.out, true);
        TraverseStrategy strategy = (configCommands.getType() == ConfigCommands.TraversalType.BREADTH) ?
                                            new BreadthFirstStrategy() : new DepthFirstStrategy();

        Reporter reporter = (configCommands.getShowDetail()) ? new DetailReporter(pw) : new SimpleReporter(pw);

        DirectoryTraverser runner = new DirectoryTraverser(strategy, reporter);
        runner.run(new File(path));

        return "Traversed = [" + path + "]";
    }

}
