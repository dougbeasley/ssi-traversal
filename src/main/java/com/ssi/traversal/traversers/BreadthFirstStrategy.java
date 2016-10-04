package com.ssi.traversal.traversers;


public class BreadthFirstStrategy<E> extends AbstractTraverseStrategy<E> {

    @Override
    public boolean enter(E e) {
        return this.list.offerLast(e);
    }

}
