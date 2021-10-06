package activity;

public interface MyList<E> {
    public int getSize();
    public void add(E data);
    public E getElement(E data);
    public boolean delete(E data); // returns false if the data is not deleted in the list
    public boolean search(E data);
}
