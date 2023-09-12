package deque;
import java.util.Iterator;
public class LinkedListDeque<T> implements Iterable<T> {
    private class Node{
         private Node prev;//指向上个节点的指针
         private T item;//每个节点中储存的数据
         private Node next;//指向下一个节点的指针
         private Node(T i,Node n){
            item = i;
            next = n;
         }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new Node(null,null);//创建哨兵节点
        size  = 0;
        //这里开始将next和prev定义为sentinel，一般化了这个链表，不用作出过多的判断
        //在开头两个节点之间插入头节点，开始没有节点的时候，可以类比于在两个sentinel之间插入
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public void addFirst(T item){
        Node firstNodeInLists  = sentinel.next;
        firstNodeInLists.prev =  new Node(item,firstNodeInLists);
        sentinel.next = firstNodeInLists.prev;
        firstNodeInLists.prev.prev = sentinel;
        size++;
    }

    public void addLast(T item) {
        Node lastNode = sentinel.prev;
        lastNode.next = new Node(item, lastNode);
        sentinel.prev = lastNode.next;
        lastNode.next.next = sentinel;
    }

    public bool isEmpty() {
        return size == 0 ? true : false;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node rmNode = sentinel.next;//要移除的节点
        T rmItem = rmNode.item;
        sentinel.next = rmNode.next;
        rmNode.next.prev = sentinel;
        rmNode.prev = null;
        rmNode.item = null;
        rmNode.next = null;
        size--;
        return rmItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node rmNode = sentinel.prev;
        T rmItem = rmNode.item;
        sentinel.prev = rmNode.prev;
        rmNode.prev.next = sentinel;
        rmNode.item = null;
        rmNode.prev = null;
        rmNode.next = null;
        size--;
        return rmItem;
    }
    public T get(int index){
        if(index<0) return null;
        int intIndex = 0;
        Node p =sentinel.next;
        while(p->item!=null){
            if(intIndex!=index) intIndex++;
            else{
                return 
            }
        }
    }

}
