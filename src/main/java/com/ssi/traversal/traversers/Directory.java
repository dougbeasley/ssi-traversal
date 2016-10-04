package com.ssi.traversal.traversers;

import java.io.File;

/**
 * Created by dbeasley on 10/3/16.
 */
public class Directory {

    private final File file;
    private final int depth;

    public Directory(File file, int depth) {
        this.file = file;
        this.depth = depth;
    }

    public String getName() {
        return this.file.getName();
    }

    public File getFile() {
        return this.file;
    }

    public int getDepth() {
        return this.depth;
    }
}
