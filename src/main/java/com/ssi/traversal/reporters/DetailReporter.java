package com.ssi.traversal.reporters;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailReporter extends SimpleReporter {


    private static final DateFormat df = SimpleDateFormat.getDateTimeInstance
                                                (SimpleDateFormat.MEDIUM, SimpleDateFormat.MEDIUM);

    public DetailReporter(PrintWriter out) {
        super(out);
    }

    @Override
    public void report(File file, int depth) {
        String name = (file.isDirectory()) ? "/" + file.getName() : details(file);
        String prefix = StringUtils.repeat('-', depth);
        out.println(String.format("%s %s", prefix, name));
    }

    private String details(File file) {
        Date modified = new Date(file.lastModified());
        StringBuilder sb = new StringBuilder();
        sb.append(file.getName());
        sb.append(String.format(" [%s, %d bytes]", df.format(modified), file.length()));
        return sb.toString();
    }

}
