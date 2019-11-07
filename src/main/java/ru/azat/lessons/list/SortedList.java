package ru.azat.lessons.list;

import java.util.Collection;
import java.util.Iterator;

public class SortedList<T extends Comparable<T>> implements Collection<T> {

    public static void main(String[] args) {
        SortedList<Double> sortedList = new SortedList<>();
        sortedList.add(1D);
        sortedList.add(3D);
        sortedList.add(2D);
        System.out.println(sortedList.toString());
        System.out.println(sortedList.size());
        sortedList.remove(2D);
        System.out.println(sortedList.toString());
        System.out.println(sortedList.size());

        SortedList<Double> sortedListSecond = new SortedList<>();
        sortedListSecond.add(1D);
        sortedListSecond.add(3D);
        sortedListSecond.add(2D);

        System.out.println(sortedList.equals(sortedListSecond));

        sortedListSecond.remove(2D);

        System.out.println(sortedList.equals(sortedListSecond));

    }

    private Element<T> first = null;
    private int length = 0;

    //isEqual
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (T p : this) {
            stringBuilder.append(p).append(" -> ");
        }
        return stringBuilder.toString();
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        for (T current : this) {
            if (current.compareTo((T) o) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new SortedListIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (first == null) {
            first = new Element<T>(t);
            length++;
            return true;
        }
        Element<T> previous = first;
        Element<T> current = first;

        if (current.getValue().compareTo(t) > 0) {
            Element<T> ne = new Element<T>(t);
            ne.setNext(first);
            first = ne;
            length++;
            return true;
        }
        while (current != null) {
            if (current.getValue().compareTo(t) > 0) {
                Element<T> next = new Element<T>(t);
                next.setNext(current);
                previous.setNext(next);
                length++;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        previous.setNext(new Element<T>(t));
        length++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Element<T> previous = null;
        Element<T> element = first;
        Element<T> target = null;
        while (element != null) {
            if (element.equals(o)) {
                target = element;
                break;
            }
            previous = element;
            element = element.getNext();
        }
        if (target == null) {
            return false;
        }
        if (previous == null) {
            first = null;
            length--;
            return true;
        }
        if (target.getNext() == null) {
            previous.setNext(null);
        }
        previous.setNext(target.getNext());
        length--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
    }

    public Element<T> getFirst() {
        return first;
    }

    @Override
    public boolean equals(Object obj) {
        SortedList<T> object = (SortedList<T>) obj;
        if (object.size() != this.size()) {
            return false;
        }

        Iterator<T> firstIterator = this.iterator();
        Iterator<T> secondIterator = object.iterator();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            if(firstIterator.next().compareTo(secondIterator.next()) != 0){
                return false;
            }
        }
        return true;
    }
}


class Element<T extends Comparable<T>> {
    private T value;
    private Element<T> next;

    public Element(T v) {
        value = v;
        next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        return value.compareTo((T) obj) == 0;
    }
}


class SortedListIterator<T extends Comparable<T>> implements Iterator<T> {

    private Element<T> current;

    public SortedListIterator(SortedList<T> sortedList) {
        current = sortedList.getFirst();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }
}
