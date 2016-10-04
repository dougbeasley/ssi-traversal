package com.ssi.traversal.traversers;

/**
 * Created by dbeasley on 10/3/16.
 */
public interface TraverseStrategy {


    boolean enter(DirNode fp);
    DirNode leave();
    DirNode peek();


}
