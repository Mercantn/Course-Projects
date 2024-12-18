import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
    private int count;

    public AccessCountArrayList() {
        super();
        this.count = 0;
    }

    public E get(int index) {
        count++;
        return super.get(index);
    }

    public E set(int index, E element) {
        count++;
        return super.set(index, element);
    }

    public int getAccessCount() {
        return count;
    }

    public void resetCount() {
        count = 0;
    }
}
