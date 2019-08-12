package datastructures.trie;

import java.util.HashMap;

class TrieNode {

  private char value;
  private HashMap<Character, TrieNode> childrens;
  private boolean end;

  public TrieNode(char value) {
    this.value = value;
    childrens = new HashMap<Character, TrieNode>();
    end = false;
  }

  public char getValue() {
    return value;
  }

  public void setValue(char value) {
    this.value = value;
  }

  public HashMap<Character, TrieNode> getChildrens() {
    return childrens;
  }

  public void setChildrens(HashMap<Character, TrieNode> childrens) {
    this.childrens = childrens;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }
}

public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode((char) 0);
  }

  public static void main(String[] args) {
    Trie dict = new Trie();
    dict.insert("are");
    dict.insert("area");
    dict.insert("base");
    dict.insert("cat");
    dict.insert("cater");
    dict.insert("basement");

    String input = "caterer";
    System.out.print(input + ":   ");
    System.out.println(dict.getMatchingPrefix(input));

    input = "basement";
    System.out.print(input + ":   ");
    System.out.println(dict.getMatchingPrefix(input));

    input = "are";
    System.out.print(input + ":   ");
    System.out.println(dict.getMatchingPrefix(input));

    input = "arex";
    System.out.print(input + ":   ");
    System.out.println(dict.getMatchingPrefix(input));

    input = "basemexz";
    System.out.print(input + ":   ");
    System.out.println(dict.getMatchingPrefix(input));

    input = "xyz";
    System.out.print(input + ":   ");
    System.out.println(dict.getMatchingPrefix(input));
  }

  public void insert(String input) {

    TrieNode temp = root;
    HashMap<Character, TrieNode> map;
    for (int i = 0; i < input.length(); i++) {

      char cha = input.charAt(i);
      map = temp.getChildrens();

      if (map.containsKey(cha)) {
        temp = map.get(cha);
      } else {
        TrieNode node = new TrieNode(cha);
        map.put(cha, node);
        temp = node;
      }
    }
    temp.setEnd(true);
  }

  public String getMatchingPrefix(String input) {
    TrieNode temp = root;
    HashMap<Character, TrieNode> map;
    String prefix = "";
    for (int i = 0; i < input.length(); i++) {

      char cha = input.charAt(i);
      map = temp.getChildrens();

      if (map.containsKey(cha)) {
        prefix += cha;
        temp = map.get(cha);

      } else break;
    }
    return prefix;
  }
}
