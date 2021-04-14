package revise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinarySearchTree {

  private BstNode rootNode;

  public BstNode getRootNode() {
    return this.rootNode;
  }

  public void insertNode(int data) {

    System.out.println("Inserting Node : " + data);
    if (getRootNode() == null) {
      this.rootNode = new BstNode(data);
      return;
    }
    insertNode(getRootNode(), data);
  }

  private BstNode insertNode(BstNode node, int data) {

    if (node == null) {
      return new BstNode(data);
    } else if (node.getData() > data) {
      node.setLeft(insertNode(node.getLeft(), data));
    } else {
      node.setRight(insertNode(node.getRight(), data));
    }
    return node;
  }

  public void infix() {
    System.out.print("\nInfix: ");
    innerInfix(getRootNode());
  }

  private void innerInfix(BstNode node) {

    if (node == null) {
      return;
    }
    if (node.getLeft() != null) {
      innerInfix(node.getLeft());
    }
    System.out.print(node.getData());
    System.out.print("  ");
    if (node.getRight() != null) {
      innerInfix(node.getRight());
    }
  }

  public void prefix() {
    System.out.print("\nPrefix: ");
    innerPrefix(getRootNode());
  }

  private void innerPrefix(BstNode node) {

    if (node == null) {
      return;
    }
    System.out.print(node.getData());
    System.out.print("  ");
    if (node.getLeft() != null) {
      innerPrefix(node.getLeft());
    }
    if (node.getRight() != null) {
      innerPrefix(node.getRight());
    }
  }

  public void postfix() {
    System.out.print("\nPostfix: ");
    innerPostfix(getRootNode());
  }

  private void innerPostfix(BstNode node) {
    if (node == null) {
      return;
    }
    if (node.getLeft() != null) {
      innerPostfix(node.getLeft());
    }
    if (node.getRight() != null) {
      innerPostfix(node.getRight());
    }

    System.out.print(node.getData() + "  ");
  }

  public void levelOrderTraversal() {
    System.out.print("\nLevel Order Traversal: ");
    Queue<BstNode> levelOrderQueue = new LinkedList<>();
    addInQueue(getRootNode(), levelOrderQueue);
    while (!levelOrderQueue.isEmpty()) {
      BstNode bstNode = levelOrderQueue.remove();
      System.out.print(bstNode.getData() + "  ");
      addInQueue(bstNode.getLeft(), levelOrderQueue);
      addInQueue(bstNode.getRight(), levelOrderQueue);
    }
  }

  private void addInQueue(BstNode node, Queue<BstNode> queue) {
    if (node != null) {
      queue.add(node);
    }
  }

  public void topView() {
    System.out.print("\nTop View: ");
    int distance = 0;
    Queue<BstNode> levelOrderQueue = new LinkedList<>();
    addInQueue(getRootNode(), levelOrderQueue, distance);
    Set<Integer> set = new HashSet<>();
    while (!levelOrderQueue.isEmpty()) {
      BstNode bstNode = levelOrderQueue.remove();
      if (!set.contains(bstNode.getLevel())) {
        System.out.print(bstNode.getData() + "  ");
        set.add(bstNode.getLevel());
      }
      addInQueue(bstNode.getLeft(), levelOrderQueue, bstNode.getLevel() - 1);
      addInQueue(bstNode.getRight(), levelOrderQueue, bstNode.getLevel() + 1);
    }
  }

  public void calculateHeight() {
    System.out.println("\nHeight Of Tree:" + height(getRootNode()));
  }

  private int height(BstNode node) {

    if (node == null) {
      return 0;
    }

    return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
  }

  private void addInQueue(BstNode node, Queue<BstNode> queue, int level) {
    if (node != null) {
      node.setLevel(level);
      queue.add(node);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insertNode(10);
    binarySearchTree.insertNode(5);
    binarySearchTree.insertNode(1);
    binarySearchTree.insertNode(15);
    binarySearchTree.insertNode(6);
    binarySearchTree.insertNode(11);
    binarySearchTree.insertNode(12);
    binarySearchTree.insertNode(13);
    binarySearchTree.insertNode(14);
    binarySearchTree.insertNode(20);
    binarySearchTree.infix();
    binarySearchTree.prefix();
    binarySearchTree.postfix();
    binarySearchTree.levelOrderTraversal();
    binarySearchTree.topView();
    binarySearchTree.calculateHeight();
  }
}

class BstNode {
  private final int data;
  private BstNode left;
  private BstNode right;
  private int level;

  public BstNode(int data) {
    this.data = data;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getData() {
    return data;
  }

  public BstNode getLeft() {
    return left;
  }

  public void setLeft(BstNode left) {
    this.left = left;
  }

  public BstNode getRight() {
    return right;
  }

  public void setRight(BstNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "BstNode{" + "data=" + data + '}';
  }
}
