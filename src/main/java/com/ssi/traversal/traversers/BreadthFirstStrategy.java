package com.ssi.traversal.traversers;

/**
 * Created by dbeasley on 10/3/16.
 */
public class BreadthFirstStrategy extends AbstractTraverseStrategy {


    @Override
    public boolean enter(DirNode dir) {
        return this.list.offerLast(dir);
    }


}
