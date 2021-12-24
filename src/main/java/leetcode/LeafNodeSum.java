package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafNodeSum {

  List<Integer> arrayList = new ArrayList<>();

  public int sumNumbers(TreeNode root) {
    return sum(root, 0);
  }

  private int sum(TreeNode node, int sum) {

    if (node == null) {
      return sum;
    }

    arrayList.add(node.val);
    if (isLeafNode(node)) {
      sum += currentLeafNodeSum();
    } else {
      sum = sum(node.left, sum);
      sum = sum(node.right, sum);
    }
    arrayList.remove((Integer) node.val);
    return sum;
  }

  private int currentLeafNodeSum() {
    int temp = 0;
    for (int i = 0; i < arrayList.size(); i++) {
      temp += arrayList.get(i) * Math.pow(10, (arrayList.size() - i - 1));
    }
    return temp;
  }

  private boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public boolean isLeafNode() {
    return this.left == null && this.right == null;
  }

  public int getVal() {
    return val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }
}
