package com.ssi.traversal.traversers;


import java.util.LinkedList;

public abstract class AbstractTraverseStrategy<E> implements TraverseStrategy<E> {


    protected LinkedList<E> list;

    public AbstractTraverseStrategy() {
        this.list = new LinkedList<E>();
    }

    public E leave() {
        return this.list.pollFirst();
    }

    public E peek() {
        return this.list.peekFirst();
    }

}
