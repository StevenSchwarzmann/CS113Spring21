package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
	private ArrayList<E> arrayStack = new ArrayList<E>();
	
    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
	@Override
    public boolean empty() {
    	return arrayStack.size() == 0;
    };

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    @Override
    public E peek() {
    	if(empty()) {
    		throw new EmptyStackException();
    	}
    	return arrayStack.get(arrayStack.size() - 1);
    };

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    @Override
    public E pop() {
    	if(empty()) {
    		throw new EmptyStackException();
    	}
    	return arrayStack.remove(arrayStack.size() - 1);
    };

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    @Override
    public E push(E obj) {
    	arrayStack.add(obj);
    	return arrayStack.get(arrayStack.size() - 1);
    };
}
