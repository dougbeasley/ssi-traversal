package com.ssi.traversal.traversers;

import com.ssi.traversal.reporters.Reporter;

import java.io.File;
import java.util.Arrays;


public class DirectoryTraverser {

    private final TraverseStrategy<Directory> strategy;
    private final Reporter reporter;


    public DirectoryTraverser(TraverseStrategy strategy, Reporter reporter) {
        this.strategy = strategy;
        this.reporter = reporter;
    }

    public void run(File root) {
        this.strategy.enter(new Directory(root, 0));

        while(this.strategy.peek() != null) {
            traverse(this.strategy);
        }
    }

    protected void traverse(TraverseStrategy traverser) {
        Directory dir = strategy.leave();

        reporter.report(dir.getFile(), dir.getDepth());

        File [] files = dir.getFile().listFiles();
        if(files != null) {
            Arrays.stream(files).forEach((file) -> {
                if (file.isDirectory()) {
                    traverser.enter(new Directory(file, dir.getDepth() + 1));
                } else {
                    reporter.report(file, dir.getDepth());
                }
            });
        } else {
            reporter.error(dir.getFile(), "Not accessible!");
        }
    }

}
