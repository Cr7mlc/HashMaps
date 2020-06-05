public class Country {

    // name
    private String name;
    //capital city
    private String capital;

    //constructor
    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
    //geting the name of the country
    public String getName() {
        return name;
    }

    public String toString(){

        return name + " : " + capital;

    }



}
