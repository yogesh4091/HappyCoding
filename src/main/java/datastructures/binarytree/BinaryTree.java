package datastructures.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** Created by 611217002 on 6/12/2017. */
public class BinaryTree {

  TreeNode root;
  int leftLevel = 0;
  int rightLevel = 0;

  public BinaryTree(int data) {
    root = new TreeNode(data);
  }

  //    			   12
  //        10			      30
  //                      25		    40
  //                 99

  public static void main(String[] args) {

    BinaryTree tree = new BinaryTree(12);
    tree.root.left = new TreeNode(10);
    tree.root.right = new TreeNode(30);
    tree.root.right.left = new TreeNode(25);
    tree.root.right.right = new TreeNode(40);
    tree.root.right.left.left = new TreeNode(99);
    System.out.println("Left View Is : ");
    tree.leftView(tree.root, 1);
    System.out.println("Right View is : ");
    tree.rightView(tree.root, 1);
    tree.levelOrderTraversal(tree.root);
    tree.levelOrderTraversalLineByLine(tree.root);
    System.out.println();
    System.out.println("Print Ancestors of 99");
    tree.printAncestor(tree.root, 99);

    /* BinaryTree tree = new BinaryTree(1);
    tree.root.left = new TreeNode(2);
    tree.root.right = new TreeNode(3);
    tree.root.right.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(5);

    if (tree.isFoldable(tree.root))
        System.out.println("tree is foldable");
    else
        System.out.println("Tree is not foldable");*/

  }

  public void leftView(TreeNode node, int level) {
    if (node == null) return;

    if (leftLevel < level) {
      System.out.println("  " + node.data);
      leftLevel = level;
    }
    leftView(node.left, level + 1);
    leftView(node.right, level + 1);
  }

  public void rightView(TreeNode node, int level) {
    if (node == null) return;

    if (rightLevel < level) {
      System.out.println("  " + node.data);
      rightLevel = level;
    }
    rightView(node.right, level + 1);
    rightView(node.left, level + 1);
  }

  public void topView(TreeNode root) {

    if (root == null) return;

    Queue<QueueItem> queue = new LinkedList<QueueItem>();
    queue.offer(new QueueItem(root, 0));
    Set<Integer> set = new HashSet<Integer>();

    while (!queue.isEmpty()) {

      QueueItem item = queue.poll();
      if (!set.contains(item.getHd())) {
        set.add(item.getHd());
        System.out.println(item.getNode().getData());
      }

      if (item.getNode().getLeft() != null) {
        queue.offer(new QueueItem(item.getNode().getLeft(), item.getHd() - 1));
      }
      if (item.getNode().getRight() != null) {
        queue.offer(new QueueItem(item.getNode().getRight(), item.getHd() + 1));
      }
    }
  }

  public boolean printAncestor(TreeNode root, int data) {

    if (root == null) return false;

    if (root.data == data) return true;

    if (printAncestor(root.left, data) || printAncestor(root.right, data)) {
      System.out.println(root.data);
      return true;
    }

    return false;
  }

  public void levelOrderTraversal(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    System.out.println("Level Order Traversal : ");
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.println(node.getData());
      if (node.getLeft() != null) {
        queue.offer(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.offer(node.getRight());
      }
    }
  }

  public void levelOrderTraversalLineByLine(TreeNode root) {

    Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
    queue.offer(root);
    System.out.println("Level Order Traversal Line By Line : ");
    while (!queue.isEmpty()) {
      int maxCount = queue.size();
      while (maxCount != 0) {
        TreeNode node = queue.poll();
        System.out.print("    " + node.getData());
        if (node.getLeft() != null) {
          queue.offer(node.getLeft());
        }
        if (node.getRight() != null) {
          queue.offer(node.getRight());
        }
        maxCount--;
      }
      System.out.println();
    }
  }

  public boolean isFoldable(TreeNode root) {

    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode node1, TreeNode node2) {

    if (node1 == null && node2 == null) return true;

    if (node1 != null && node2 != null)
      return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

    //        if ((node1.left != null && node2.right == null) || node1.left == null && node2.right
    // != null) {
    return false;
    //        }
  }

  class QueueItem {
    TreeNode node;
    int hd;

    public QueueItem(TreeNode node, int hd) {

      this.node = node;
      this.hd = hd;
    }

    public TreeNode getNode() {
      return node;
    }

    public void setNode(TreeNode node) {
      this.node = node;
    }

    public int getHd() {
      return hd;
    }

    public void setHd(int hd) {
      this.hd = hd;
    }
  }
}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "TreeNode{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
  }
}
