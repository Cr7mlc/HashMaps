/**
 * This class is an implementation of the node of a linkedList using the data as the Country class;
 * */

public class Node {
    private Node nextNode;
    private Country country;

    public Node(Country country) {
        this.country = country;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String toString(){

        return getCountry().toString();

    }
}
