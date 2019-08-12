package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** Created by 611217002 on 5/11/2017. */
public class BST {

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(20);
    binarySearchTree.insert(10);
    binarySearchTree.insert(35);
    binarySearchTree.insert(5);
    binarySearchTree.insert(7);
    binarySearchTree.insert(15);
    binarySearchTree.insert(25);
    binarySearchTree.insert(35);
    binarySearchTree.insert(13);
    binarySearchTree.insert(18);
    System.out.println("Infix : ");
    binarySearchTree.infix(binarySearchTree.root);
    System.out.println();
    System.out.println("Prefix : ");
    binarySearchTree.prefix(binarySearchTree.root);
    System.out.println("Iterative Prefix");
    binarySearchTree.iterativePreorder(binarySearchTree.root);
    System.out.println();
    System.out.println("Postfix : ");
    binarySearchTree.postfix(binarySearchTree.root);
    System.out.println("Search Node 80 :");
    binarySearchTree.searchAndTraverse(80);
    System.out.println();
    binarySearchTree.minValue();
    binarySearchTree.inorderProcessor(binarySearchTree.root, 10);
    binarySearchTree.inorderProcessor(binarySearchTree.root, 30);
    binarySearchTree.leastCommonAncestor(15, 7);
    binarySearchTree.smallestElement(1);
    binarySearchTree.smallestElement(2);
    binarySearchTree.smallestElement(3);
    binarySearchTree.smallestElement(4);
    binarySearchTree.smallestElement(5);
    binarySearchTree.smallestElement(6);
    binarySearchTree.smallestElement(7);
    int[] tree1 = {3, 5, 4, 6, 1, 0, 2};
    int[] tree2 = {3, 1, 5, 2, 4, 6, 0};
    System.out.println("Trees are identical : " + binarySearchTree.identicalTree(tree1, tree2));
    System.out.println(
        "Height of Tree is : " + binarySearchTree.heightOfTree(binarySearchTree.root));
    System.out.println("Level Wise Print : ");
    binarySearchTree.levelWisePrint(binarySearchTree.root);
    System.out.println();
    System.out.println("Size of Tree : " + binarySearchTree.sizeOfTree(binarySearchTree.root));
    System.out.println(
        "Leaf Node count : " + binarySearchTree.countLeafNode(binarySearchTree.root));
    System.out.println("Level Order Traversal : ");
    binarySearchTree.levelOrderTraversal();
    System.out.println("Spiral Form : ");
    binarySearchTree.spiralForm(binarySearchTree.root);
  }
}

class BinarySearchTree {
  Node root;
  int count = 0;
  Queue<Node> queue = new LinkedList<Node>();

  public BinarySearchTree() {
    root = null;
  }

  public void insert(int data) {
    root = insertData(root, data);
  }

  private Node insertData(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    } else {

      if (data < root.getData()) {
        root.setLeft(insertData(root.getLeft(), data));
      } else {
        root.setRight(insertData(root.getRight(), data));
      }
      return root;
    }
  }

  public void infix(Node root) {
    if (root == null) return;
    if (root.getLeft() != null) {
      infix(root.getLeft());
    }
    System.out.print(root.getData() + "  ");

    if (root.getRight() != null) {
      infix(root.getRight());
    }
  }

  public void iterativePreorder(Node root) {
    Stack<Node> nodes = new Stack<Node>();
    nodes.push(root);

    Node currentNode;

    while (!nodes.isEmpty()) {
      currentNode = nodes.pop();
      Node right = currentNode.getRight();
      if (right != null) {
        nodes.push(right);
      }
      Node left = currentNode.getLeft();
      if (left != null) {
        nodes.push(left);
      }
      System.out.print(currentNode.getData() + "  ");
    }
  }

  public void iterativeInorder(Node root) {}

  public void prefix(Node root) {
    if (root == null) return;
    System.out.print(root.getData() + "  ");

    if (root.getLeft() != null) {
      prefix(root.getLeft());
    }

    if (root.getRight() != null) {
      prefix(root.getRight());
    }
  }

  public void postfix(Node root) {
    if (root == null) return;
    if (root.getLeft() != null) {
      postfix(root.getLeft());
    }

    if (root.getRight() != null) {
      postfix(root.getRight());
    }

    System.out.print(root.getData() + "  ");
  }

  public void searchAndTraverse(int data) {
    Node node = searchNode(root, data);
    if (node == null) {
      System.out.println(" Node Not Found.");
    } else {
      System.out.println("Node found and infix traversal from there :");
      infix(node);
    }
  }

  private Node searchNode(Node root, int data) {
    if (root == null) return root;
    if (root.getData() == data) return root;
    if (data < root.getData()) return searchNode(root.getLeft(), data);
    else return searchNode(root.getRight(), data);
  }

  public int minValue() {
    Node temp = root;
    int data = 0;
    while (temp != null) {
      data = temp.getData();
      temp = temp.getLeft();
    }
    System.out.println("Min. value in BST is : " + data);
    return data;
  }

  public void inorderProcessor(Node root, int data) {

    if (root == null) {
      System.out.println("Node not found");
      return;
    }

    if (root.getData() == data) {
      if (root.getLeft() != null) {
        Node temp = root.getLeft();
        while (temp.getRight() != null) {
          temp = temp.getRight();
        }
        System.out.println("Predecessor is : " + temp.getData());
      }

      if (root.getRight() != null) {
        Node temp = root.getRight();
        while (temp.getLeft() != null) {
          temp = temp.getLeft();
        }
        System.out.println("Successor is : " + temp.getData());
      }
      return;
    }

    if (root.getData() > data) {
      inorderProcessor(root.getLeft(), data);
    } else {
      inorderProcessor(root.getRight(), data);
    }
  }

  public Node leastCommonAncestor(int key1, int key2) {

    Node node1 = searchNode(this.root, key1 < key2 ? key1 : key2);
    Node node2 = searchNode(this.root, key1 < key2 ? key2 : key1);
    if (node1 == null || node2 == null) {
      System.out.println("Node not found");
      return null;
    }
    Node temp = this.root;
    while (temp != null) {
      if (node1.getData() <= temp.getData() && node2.getData() >= temp.getData()) {
        System.out.println("Least Common Ancestor is : " + temp.getData());
        return temp;
      }

      if (node1.getData() < temp.getData() && node2.getData() < temp.getData()) {
        temp = temp.getLeft();
        continue;
      }

      if (node1.getData() > temp.getData() && node2.getData() > temp.getData()) {
        temp = temp.getRight();
      }
    }
    System.out.println("LCA Not Found");
    return null;
  }

  public void smallestElement(int k) {
    count = 0;
    kthSmallest(k, root);
  }

  private void kthSmallest(int k, Node node) {

    if (node == null) {
      return;
    }

    if (node.getLeft() != null) {
      kthSmallest(k, node.getLeft());
    }

    count++;
    if (count == k) {
      System.out.println(k + " Smallest Element is : " + node.getData());
      return;
    }

    if (node.getRight() != null) {
      kthSmallest(k, node.getRight());
    }
  }

  public boolean identicalTree(int[] array1, int[] array2) {
    if (array1.length != array2.length) return false;
    if (array1.length == 0) return true;
    if (array1[0] != array2[0]) return false;
    if (array1.length == 1) return true;
    int[] smallerValues1 = new int[array1.length - 1];
    int[] smallerValues2 = new int[array1.length - 1];
    int[] largerValues1 = new int[array1.length - 1];
    int[] largerValues2 = new int[array1.length - 1];
    int smallCount1 = 0;
    int smallCount2 = 0;
    int largeCount1 = 0;
    int largeCount2 = 0;
    for (int i = 1; i < array1.length; i++) {
      if (array1[i] < array1[0]) smallerValues1[smallCount1++] = array1[i];
      if (array1[i] >= array1[0]) largerValues1[largeCount1++] = array1[i];
      if (array2[i] < array2[0]) smallerValues2[smallCount2++] = array2[i];
      if (array2[i] >= array2[0]) largerValues2[largeCount2++] = array2[i];
    }

    return identicalTree(smallerValues1, smallerValues2)
        && identicalTree(largerValues1, largerValues2);
  }

  public int heightOfTree(Node root) {
    if (root == null) return 0;

    int leftHeight = heightOfTree(root.getLeft());
    int rightHeight = heightOfTree(root.getRight());

    if (leftHeight > rightHeight) return leftHeight + 1;
    else return rightHeight + 1;
  }

  void printGivenLevel(Node root, int level) {
    if (root == null) return;
    if (level == 1) System.out.print(root.getData() + " ");
    else if (level > 1) {
      printGivenLevel(root.getLeft(), level - 1);
      printGivenLevel(root.getRight(), level - 1);
    }
  }

  void levelWisePrint(Node root) {
    int height = heightOfTree(root);
    for (int i = 1; i <= height; i++) {
      printGivenLevel(root, i);
    }
  }

  public int sizeOfTree(Node root) {
    if (root == null) {
      return 0;
    }

    return sizeOfTree(root.getLeft()) + sizeOfTree(root.getRight()) + 1;
  }

  public int countLeafNode(Node root) {
    if (root == null) return 0;

    if (root.getLeft() == null && root.getRight() == null) {
      return 1;
    }

    return countLeafNode(root.getLeft()) + countLeafNode(root.getRight());
  }

  public void levelOrderTraversal() {
    System.out.println("Level order traversal using queue : ");
    queue.add(root);
    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      levelOrderTraversal(temp);
    }
  }

  private void levelOrderTraversal(Node root) {

    if (root == null) return;
    System.out.print(root.getData() + "\t");
    if (root.getLeft() != null) queue.add(root.getLeft());
    if (root.getRight() != null) queue.add(root.getRight());
  }

  private void printLevelForSpiral(Node root, int level, boolean toggle) {
    if (root == null) return;
    if (level == 1) System.out.print(root.getData() + " ");
    else if (level > 1) {
      if (toggle) {
        printLevelForSpiral(root.getLeft(), level - 1, toggle);
        printLevelForSpiral(root.getRight(), level - 1, toggle);
      } else {
        printLevelForSpiral(root.getRight(), level - 1, toggle);
        printLevelForSpiral(root.getLeft(), level - 1, toggle);
      }
    }
  }

  void spiralForm(Node root) {
    int height = heightOfTree(root);
    boolean toggle = false;
    for (int i = 1; i <= height; i++) {
      printLevelForSpiral(root, i, toggle);
      toggle = !toggle;
    }
  }
}

class Node {

  private Node left;
  private Node right;
  private int data;

  public Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }
}
