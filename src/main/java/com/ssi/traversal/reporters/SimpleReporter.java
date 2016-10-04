package com.ssi.traversal.reporters;



import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;

public class SimpleReporter implements Reporter {


    protected final PrintWriter out;

    public SimpleReporter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void report(File file, int depth) {
        String name = (file.isDirectory()) ? "/" + file.getName() : file.getName();
        String prefix = StringUtils.repeat('-', depth);
        out.println(String.format("%s %s", prefix, name));
    }

    @Override
    public void error(File file, String msg) {
        out.format("error [%s] - %s", file.getAbsoluteFile(), msg);
    }
}
