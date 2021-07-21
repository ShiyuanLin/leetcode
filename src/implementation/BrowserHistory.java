package implementation;

public class BrowserHistory {

  class DoubleLinkedList {
    DoubleLinkedList prev;
    DoubleLinkedList next;
    String url;

    DoubleLinkedList(String url) {
      this.url = url;
      this.prev = null;
      this.next = null;
    }
  }

  DoubleLinkedList homepageNode;
  DoubleLinkedList currNode;
  DoubleLinkedList tailNode;

  public BrowserHistory(String homepage) {
    this.homepageNode = new DoubleLinkedList(homepage);
    this.tailNode = this.homepageNode;
    this.currNode = this.homepageNode;
  }

  public void visit(String url) {
    DoubleLinkedList newNode = new DoubleLinkedList(url);
    this.currNode.next = newNode;
    newNode.prev = this.currNode;
    this.currNode = newNode;
    this.tailNode = this.currNode;
  }

  public String back(int steps) {
    for (int i = 0; i < steps; i++) {
      if (this.currNode.prev == null) {
        return this.currNode.url;
      } else {
        this.currNode = this.currNode.prev;
      }
    }
    return this.currNode.url;
  }

  public String forward(int steps) {
    for (int i = 0; i < steps; i++) {
      if (this.currNode.next == null) {
        return this.currNode.url;
      } else {
        this.currNode = this.currNode.next;
      }
    }
    return this.currNode.url;
  }
}
