package com.ssi.traversal.reporters;

import java.io.File;

public interface Reporter {

    void report(File file, int depth);
    void error(File file, String msg);

}
