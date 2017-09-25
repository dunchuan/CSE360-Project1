package edu.asu.CSE360._04._03;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MostRecentQueue<E> {
    private E mostRecent;

    private LinkedList<E> linkedList = new LinkedList<>();

    private int cycleIndex;
    private boolean isCycling;

    public MostRecentQueue(E mostRecent) {
        this.mostRecent = mostRecent;
    }

    public synchronized void cycle(List<E> cycleList) {
        clear();
       linkedList.addAll(cycleList);
       isCycling = true;
    }

    public synchronized  E poll() {
        if (linkedList.size() == 0)
            return mostRecent;
        else
            if (isCycling) {
                E head = linkedList.poll();
                linkedList.add(head);
                return head;
            }

            return linkedList.poll();

    }

    public synchronized void add(E e) {
        linkedList.add(e);
        isCycling = false;
    }


    public synchronized void clear() {
        linkedList.clear();
        isCycling = false;
    }

    public synchronized void clear(E defaultValue) {
        clear();
        mostRecent = defaultValue;
    }

    public synchronized E getTail() {
        try {
            return linkedList.getLast();
        } catch (NoSuchElementException e) {
            return mostRecent;
        }

    }
}
