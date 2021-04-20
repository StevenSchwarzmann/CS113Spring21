package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E>{
	private Queue<E> arrayQueue = new LinkedList<E>();  

	public CircularArrayQueue(int initialCapacity) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		return arrayQueue.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return arrayQueue.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		return arrayQueue.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return arrayQueue.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return arrayQueue.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return arrayQueue.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return arrayQueue.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return arrayQueue.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return arrayQueue.retainAll(c);
	}

	@Override
	public void clear() {
		arrayQueue.clear();
		
	}

	@Override
	public boolean add(E e) {
		return arrayQueue.add(e);
	}

	@Override
	public boolean offer(E e) {
		return arrayQueue.offer(e);
	}

	@Override
	public E remove() {
		return arrayQueue.remove();
	}

	@Override
	public E poll() {
		return arrayQueue.poll();
	}

	@Override
	public E element() {
		return arrayQueue.element();
	}

	@Override
	public E peek() {
		return arrayQueue.peek();
	}
	
}
