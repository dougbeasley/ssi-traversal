package com.ssi.traversal.traversers;

/**
 * Created by dbeasley on 10/3/16.
 */
public interface TraverseStrategy<E> {


    boolean enter(E e);
    E leave();
    E peek();


}
