import java.util.Scanner;

public class Test {

    public static void main(String []args){

        Countries_Capital c = new Countries_Capital(11);
//      c.displayAllCountries();
        Scanner scan = new Scanner(System.in);
        String countryName  = "";

        while(!countryName.equals("x")){

            System.out.print("Type a Country: -->");
            countryName = scan.nextLine();
            System.out.println(c.searchCountry(countryName));

        }


    }

}
