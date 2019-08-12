package datastructures.linkedlist;

import java.util.HashSet;

/** Created by 611217002 on 5/23/2017. */
public class LinkedList<T> {

  Nodes<T> start;

  public LinkedList() {
    start = null;
  }

  public static void main(String[] args) {

    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.insertAtLast(5);
    linkedList.insertAtLast(15);
    linkedList.insertAtLast(45);
    linkedList.insertInFront(1);
    linkedList.insertAtLast(35);
    linkedList.insertInBetween(99, 4);
    System.out.println("Search element : " + linkedList.search(1));
    System.out.println("Delete element from the end");
    linkedList.deleteFromEnd();
    System.out.println("Delete element from front");
    linkedList.deleteFromFront();
    linkedList.deleteFromMid(3);
    linkedList.insertAtLast(55);
    linkedList.insertAtLast(65);
    System.out.println("Traversed Normally : ");
    linkedList.traverse();
    System.out.print("Traversed using toString() : ");
    linkedList.traverseUsingToString();
    Nodes node65 = linkedList.kthNodeFromEnd(1);
    Nodes node15 = linkedList.kthNodeFromEnd(3);
    node65.setNext(node15);
    System.out.println(linkedList.detectLoop());

    //        linkedList.traverse();
    //        linkedList.detectAndRemoveLoopUsingSet();
    linkedList.detectAndRemoveLoop(linkedList.start);
    linkedList.traverse();
    //        linkedList.start = linkedList.ReverseRecursion(linkedList.start);
    //        linkedList.traverse();
    linkedList.start = linkedList.reverseIterative(linkedList.start);
    linkedList.traverse();
    //        linkedList.swapKthNodeFromEnd(1);
  }

  public void insertAtLast(T data) {
    Nodes<T> temp = start;
    Nodes<T> newNode = new Nodes<T>(data);

    if (start == null) {
      start = newNode;
    } else {
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
  }

  public void insertInFront(T data) {
    Nodes<T> newNode = new Nodes<T>(data);
    newNode.setNext(start);
    start = newNode;
  }

  public void insertInBetween(T dataToInsert, int kthPosition) {
    int counter = 1;
    Nodes<T> temp = start;
    while (temp.getNext() != null && counter != kthPosition) {
      temp = temp.getNext();
      counter++;
    }
    Nodes<T> newNode = new Nodes<T>(dataToInsert);
    newNode.setNext(temp.getNext());
    temp.setNext(newNode);
  }

  public void traverse() {
    if (detectLoop()) {
      System.out.println("Loop detected");
      return;
    }
    Nodes temp = start;
    while (temp != null) {
      System.out.println(temp.getData());
      temp = temp.getNext();
    }
  }

  public void traverseUsingToString() {
    System.out.println(start);
  }

  public Nodes<T> search(T data) {
    Nodes temp = start;
    while (temp != null) {
      if (temp.getData() == data) {
        return temp;
      }
      temp = temp.getNext();
    }
    return temp;
  }

  Nodes ReverseRecursion(Nodes head) {

    if (head == null) {
      return null;
    }

    if (head.getNext() == null) {
      return head;
    }

    Nodes rest = head.getNext();

    head.setNext(null);
    Nodes reverseList = ReverseRecursion(rest);

    rest.setNext(head);
    return reverseList;
  }

  Nodes reverseIterative(Nodes head) {

    if (head == null) return null;
    if (head.getNext() == null) return head;
    Nodes temp = head;
    Nodes prev = null;
    Nodes next;
    while (temp != null) {
      next = temp.getNext();
      temp.setNext(prev);
      prev = temp;
      temp = next;
    }
    head = prev;
    return head;
  }

  public void deleteFromFront() {
    if (start != null) {
      start.setData(null);
      start = start.getNext();
    }
  }

  public void deleteFromEnd() {
    Nodes last = start;
    Nodes secondLast = start;
    while (last.getNext() != null) {
      secondLast = last;
      last = last.getNext();
    }
    secondLast.setNext(null);
  }

  public void deleteFromMid(int kthPosition) {
    Nodes temp = start;
    //        Nodes prevNode = start;
    int counter = 1;
    while (temp.getNext() != null && counter != kthPosition) {
      counter++;
      //            prevNode = temp;
      temp = temp.getNext();
    }
    temp.setNext(temp.getNext().getNext());
  }

  public Nodes kthNodeFromEnd(int k) {
    Nodes pointer1 = start;
    Nodes pointer2 = start;
    int counter = 0;
    while (counter != k && pointer1 != null) {
      pointer1 = pointer1.getNext();
      counter++;
    }

    while (pointer1 != null) {
      pointer1 = pointer1.getNext();
      pointer2 = pointer2.getNext();
    }
    return pointer2;
  }

  public void swapKthNodeFromEnd(int k) {
    Nodes pointer1 = start;
    Nodes pointer2 = start;
    int counter = 1;
    while (counter != k && pointer1 != null) {
      pointer1 = pointer1.getNext();
      counter++;
    }
    Nodes kthNodeFromStart = pointer1;
    while (pointer1.getNext() != null) {
      pointer1 = pointer1.getNext();
      pointer2 = pointer2.getNext();
    }
    Object data = kthNodeFromStart.getData();
    kthNodeFromStart.setData(pointer2.getData());
    pointer2.setData(data);
    System.out.println("After Swapping : \n" + start);
  }

  public boolean detectLoop() {
    Nodes pointer1 = start;
    Nodes pointer2 = start;
    boolean loopPresent = false;
    while (pointer2 != null && pointer2.getNext() != null) {
      pointer1 = pointer1.getNext();
      pointer2 = pointer2.getNext().getNext();
      if (pointer1 == pointer2) {
        loopPresent = true;
        break;
      }
    }

    return loopPresent;
  }

  public void detectAndRemoveLoopUsingSet() {
    if (!detectLoop()) return;
    HashSet keepInLinkedList = new HashSet();
    Nodes temp = start;
    while (temp.getNext() != null) {
      if (keepInLinkedList.contains(temp.getNext())) {
        temp.setNext(null);
        break;
      }
      keepInLinkedList.add(temp);

      temp = temp.getNext();
    }
    traverse();
  }

  // Function that detects loop in the list
  void detectAndRemoveLoop(Nodes node) {

    // If list is empty or has only one node
    // without loop
    if (node == null || node.getNext() == null) return;

    Nodes slow = node, fast = node;

    // Search for loop using slow and fast pointers
    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast) {
        slow = node;
        while (slow.getNext() != fast.getNext()) {
          slow = slow.getNext();
          fast = fast.getNext();
        }

        /* since fast->getNext() is the looping point */
        fast.setNext(null); /* remove loop */
        break;
      }
    }
  }
}

class Nodes<T> {

  public T data;
  public Nodes next;

  Nodes(T data) {
    this.data = data;
  }

  T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  Nodes getNext() {
    return next;
  }

  void setNext(Nodes next) {
    this.next = next;
  }
}
