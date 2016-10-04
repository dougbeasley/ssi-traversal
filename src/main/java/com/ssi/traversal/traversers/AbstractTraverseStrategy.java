package com.ssi.traversal.traversers;


import java.util.LinkedList;

public abstract class AbstractTraverseStrategy implements TraverseStrategy {


    protected LinkedList<DirNode> list;

    public AbstractTraverseStrategy() {
        this.list = new LinkedList<DirNode>();
    }

    public DirNode leave() {
        return this.list.pollFirst();
    }

    public DirNode peek() {
        return this.list.peekFirst();
    }

}
