
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * MostRecentQueue Class is a Queue that never runs out.  When the last item
 * of the queue is consumed, additional polling will show the last item
 * taken from the queue.  It also allows for "cycling" where items removed
 * are added back into the queue.
 *
 * Recitation Project 2
 * Completion time: 0.5 hours
 *
 * @author Robert Wasinger * @version 1.0
 */
public class MostRecentQueue<E> {
    private E mostRecent;

    private LinkedList<E> linkedList = new LinkedList<>();

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

    public synchronized void add (List<E> list) {
        linkedList.addAll(list);
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
