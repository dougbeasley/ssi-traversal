package com.ssi.traversal.traversers;

/**
 * Created by dbeasley on 10/3/16.
 */
public class DepthFirstStrategy<E> extends AbstractTraverseStrategy<E> {


    @Override
    public boolean enter(E e) {
        return this.list.offerFirst(e);
    }
}
