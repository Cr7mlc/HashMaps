/**
 *
 * This class is an implementation of the LinkedList class. The nodes having the data of the Countries and pointed to the next Node
 * */

public class CountryLinkedList {
    //reference the headNode
    private Node firstCountry = null;

    //insert to head --> This method is call if a country is inserted in a slot which was not null
    public void insertCountryToList(Country country) {
        //creating a new Node
        Node newNode = new Node(country);
        //pointing the next node of the new Node to the head Node
        newNode.setNextNode(this.firstCountry);
        //changing the head node to the new node inserted
        this.firstCountry = newNode;

    }

    //display the Country List
    public void displayCountryList(){
        //the current node referring to the head node
        Node current = this.firstCountry;
        while (current!= null){
            System.out.println(current);
            current = current.getNextNode();
        }

    }
    //finding the country in the list
    public Country findCountry(String name){
        //the current node referring to the head node
        Node current = this.firstCountry;
        while(current != null){
            if(current.getCountry().getName().toLowerCase().contains(name.toLowerCase().trim())) return current.getCountry();
            current = current.getNextNode();
        }
        return null;
    }

}
