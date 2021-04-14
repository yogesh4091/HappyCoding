package datastructures.graph;

import java.util.*;

public class Graph<T> {

  private Map<Vertex<T>, List<Vertex<T>>> nodes;

  public Graph() {
    nodes = new HashMap<>();
  }

  public Vertex<T> addVertex(T data) {
    Vertex<T> vertex = new Vertex<>(data);
    nodes.putIfAbsent(vertex, new LinkedList<>());
    return vertex;
  }

  public void addEdge(T first, T second) {
    Vertex<T> firstVertex = addVertex(first);
    Vertex<T> secondVertex = addVertex(second);
    nodes.get(firstVertex).add(secondVertex);
    nodes.get(secondVertex).add(firstVertex);
  }

  public void removeVertex(T data) {
    Vertex<T> removeVertex = new Vertex<>(data);
    // remove current vertex from adjacent nodes.
    nodes.computeIfPresent(
        removeVertex,
        (v, adjNodes) -> {
          adjNodes.forEach(vertex -> nodes.get(vertex).remove(removeVertex));
          return adjNodes;
        });
    // remove the reference.
    nodes.remove(removeVertex);
  }

  public void removeEdge(T first, T second) {
    Vertex<T> firstVertex = new Vertex<>(first);
    Vertex<T> secondVertex = new Vertex<>(second);
    removeConnection(firstVertex, secondVertex);
    removeConnection(secondVertex, firstVertex);
  }

  private void removeConnection(Vertex<T> one, Vertex<T> two) {
    if (nodes.containsKey(one)) {
      nodes.get(one).remove(two);
    }
  }

  public void breadthFirstSearch(T data) {

    System.out.println("BFS: ");
    Queue<Vertex<T>> queue = new LinkedList<>();
    List<Vertex<T>> visitedNodes = new ArrayList<>();
    Vertex<T> firstNode = new Vertex<>(data);

    if (!nodes.containsKey(firstNode)) {
      System.out.println("Invalid Vertex");
      return;
    }

    queue.add(firstNode);
    while (!queue.isEmpty()) {
      Vertex<T> tVertex = queue.remove();
      visitedNodes.add(tVertex);
      System.out.print(tVertex.getData() + "   ");

      nodes.get(tVertex).stream()
          .filter(adjVertex -> !visitedNodes.contains(adjVertex))
          .forEach(
              adjVertex -> {
                visitedNodes.add(adjVertex);
                queue.add(adjVertex);
              });
    }
  }

  public void depthFirstSearch(T data) {
    // 0   1   2   3   4   5   6
    Vertex<T> firstNode = new Vertex<>(data);
    System.out.println("\nDFS:");
    if (!nodes.containsKey(firstNode)) {
      System.out.println("Invalid Vertex");
      return;
    }

    Stack<Vertex<T>> stack = new Stack<>();
    stack.push(firstNode);
    List<Vertex<T>> visitedNodes = new ArrayList<>();

    while (!stack.isEmpty()) {
      Vertex<T> vertex = stack.pop();
      if (!visitedNodes.contains(vertex)) {
        visitedNodes.add(vertex);
        nodes.get(vertex).forEach(stack::push);
      }
    }
    visitedNodes.forEach(element -> System.out.print(element.getData() + "   "));
  }

  public static void main(String[] args) {
    Graph<Integer> graph = new Graph<>();
    graph.addVertex(0);
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(5, 6);
    graph.breadthFirstSearch(0);
    graph.depthFirstSearch(0);
  }
}

class Vertex<T> {
  private final T data;

  public Vertex(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vertex<?> vertex = (Vertex<?>) o;
    return Objects.equals(data, vertex.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }
}
