package com.ssi.traversal.traversers;

import com.ssi.traversal.reporters.Reporter;

import java.io.File;
import java.util.Arrays;


public class TraverseRunner {

    private final TraverseStrategy traverser;
    private final Reporter reporter;


    public TraverseRunner(TraverseStrategy traverser, Reporter reporter) {
        this.traverser = traverser;
        this.reporter = reporter;
    }

    public void run(String rootPath) {
        this.traverser.enter(new DirNode(new File(rootPath), 0));

        while(this.traverser.peek() != null) {
            traverse(this.traverser);
        }
    }

    protected void traverse(TraverseStrategy traverser) {
        DirNode dir = traverser.leave();

        reporter.report(dir.getFile(), dir.getDepth());

        File [] files = dir.getFile().listFiles();
        if(files != null) {
            Arrays.stream(files).forEach((file) -> {
                if (file.isDirectory()) {
                    traverser.enter(new DirNode(file, dir.getDepth() + 1));
                } else {
                    reporter.report(file, dir.getDepth());
                }
            });
        } else {
            reporter.error(dir.getFile(), "Not accessable");
        }
    }

}
