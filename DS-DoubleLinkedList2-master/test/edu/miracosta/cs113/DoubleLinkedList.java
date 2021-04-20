package edu.miracosta.cs113;
import java.util.AbstractSequentialList;	
import java.util.Iterator;	
import java.util.ListIterator;	
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> extends AbstractSequentialList<E> { // Data fields
	private Node<E> head = null; // points to the head of the list
	private Node<E> tail = null; // points to the tail of the list
	private int size = 0; // the number of items in the list
	
	@Override
	public void add(int index, E obj) { // Fill Here
		listIterator(index).add(obj);
	}

	public void addFirst(E obj) { // Fill Here
		add(0, obj);
	}

	public void addLast(E obj) { // Fill Here
		add(size, obj);
	}

	@Override
	public E get(int index) {
		ListIterator iterator = new ListIter(index);
		if(!(iterator.hasNext())) {
			throw new IndexOutOfBoundsException();
		}
		return listIterator(index).next();
	}

	public E getFirst() {
		return head.data;
	}

	public E getLast() {
		return tail.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E remove(int index) {
		E returnValue = null;
		ListIterator<E> iter = listIterator(index);
		if (iter.hasNext()) {
			returnValue = iter.next();
			iter.remove();
		} else {
			throw new IndexOutOfBoundsException();
		}
		return returnValue;
	}

	public Iterator<E> iterator() {
		return new ListIter(0);
	}

	public ListIterator<E> listIterator() {
		return new ListIter(0);
	}

	public ListIterator<E> listIterator(int index) {
		return new ListIter(index);
	}

	public ListIterator<E> listIterator(ListIterator<E> iter) {
		return new ListIter((ListIter) iter);
	}
	
	@Override
    public int indexOf(Object o) {
        Iterator<E> itr = iterator();
        int index = 0;
        while (itr.hasNext()) {
            if (o.equals(itr.next())) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

	// Inner Classes
	private static class Node<E> {
		private E data;
		private Node<E> next = null;
		private Node<E> prev = null;

		private Node(E dataItem) // constructor
		{
			data = dataItem;
		}
	} // end class Node

	public class ListIter implements ListIterator<E> {
		private Node<E> currentNode;
		private Node<E> previousNode;
		private int index = 0;

		public ListIter(int i) // constructor for ListIter class
		{
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			previousNode = null;

			if (i == size) // Special case of last item
			{
				index = size;
				currentNode = null;
			} else // start at the beginning
			{
				currentNode = head;
				for (index = 0; index < i; index++)
					currentNode = currentNode.next;
			} // end else
		} // end constructor

		public ListIter(ListIter other) {
			ListIter itr = new ListIter(0);
			itr.index = other.index;
			itr.previousNode = other.previousNode;
			itr.currentNode = other.currentNode;
		}

		public boolean hasNext() {
			return currentNode != null;
		}

		public boolean hasPrevious() {
			if(head == null) {
				return false;
			}
			return (currentNode == null && size != 0) || currentNode.prev != null;
		}

		public int previousIndex() {
			return index - 1;
		}

		public int nextIndex() {
			return index;
		}

		public void set(E o) {
			if(previousNode == null) {
				throw new IllegalStateException();
			}
			previousNode.data = o;
		}

		@Override
        public void remove() {
            if (previousNode == null) {
                throw new IllegalStateException();
            }
            if (previousNode.next != null) {
            	previousNode.next.prev = previousNode.prev;
            } else { // Item is the tail
                tail = previousNode.prev;
                if (tail != null) {
                    tail.next = null;
                } else { // list is now empty
                    head = null;
                }
            }
            if (previousNode.prev != null) {
            	previousNode.prev.next = previousNode.next;
            } else { // Item is the head
                head = previousNode.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            }
            size--;
            index--;
        }

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
			index++;
			return previousNode.data;
		}

		@Override
		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(currentNode == null) {
				currentNode = tail;
			} else {
				currentNode = currentNode.prev;
			}
			previousNode = currentNode;
			index--;
			return previousNode.data;
		}
		
		@Override
		public void add(E obj) {
			if(head == null) { // empty list
				head = new Node<E>(obj);
				tail = head;
			} else if(currentNode == head) { // insert head
				Node<E> newNode = new Node<>(obj);
				newNode.next = currentNode;
				currentNode.prev = newNode;
				head = newNode;
			} else if(currentNode == null) { // insert tail
				Node<E> newNode = new Node<>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			} else { 
				Node<E> newNode = new Node<>(obj);
				newNode.prev = currentNode.prev;
				currentNode.prev.next = newNode;
                newNode.next = currentNode;
                currentNode.prev = newNode;
			}
			index++;
			size++;
			previousNode = null;
		}
	}// end of inner class ListIter
}// end of class DoubleLinkedList
