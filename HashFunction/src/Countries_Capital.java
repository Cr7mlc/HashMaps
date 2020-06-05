
/**
 * This is an Implementation of HashMaps, I avoided clustering by using the linkedList Implementation.
 *
 * This Implementation takes a 2D array of Countries and their capital city. The country name being the key, when you run the program with a specific country
 * it returns the country capital city as the value.
 *
 *
 * */

public class Countries_Capital {
    private CountryLinkedList[] listOfCountries;
    private int arraySize;
    private int items =0;
    // List of Countries and Capital, this list was copied from the book Thinking in Java By Bruce Eckel-->
    // link: https://books.google.ca/books?id=Ql6QgWf6i7cC&pg=PA487&dq=double+string+array+of+countries+and+capital&hl=en&sa=X&ved=0ahUKEwiiq5bcouPpAhWndN8KHezfBIUQ6AEIMzAB#v=onepage&q&f=false

    public static final String[] [] pairsCountries = {
            // Africa
            {"ALGERIA","Algiers"}, {"ANGOLA", "Luanda"}, {"BENIN", "Porto-Novo"}, {"BOTSWANA", "Gaberone"},{"BURKINA FASO", "Ouagadougou"},
            {"BURUNDI", "Bujumbura"},{"CAMEROON", "Yaounde"}, {"CAPE VERDE", "Praia"},{"CENTRAL AFRICAN REPUBLIC","Bangui"},{"CHAD", "N'djamena"},
            {"COMOROS", "Moroni"},{"CONGO", "Brazzaville"}, {"DJIBOUTI", "Dijibouti"},{"EGYPT", "Cairo"}, {"EQUATORIAL GUINEA", "Malabo"},
            {"ERITREA", "Asmara"}, {"ETHIOPIA", "Addis Ababa"},{"GABON", "Libreville"}, {"THE GAMBIA", "Banjul"},{"GHANA", "Accra"}, {"GUINEA", "Conakry"},
            {"GUINEA BISSAU", "Bissau"},{"IVORY COAST", "Yamoussoukro"},{"KENYA", "Nairobi"}, {"LESOTHO", "Maseru"},{"LIBERIA", "Monrovia"}, {"LIBYA", "Tripoli"},
            {"MADAGASCAR", "Antananarivo"}, {"MALAWI", "Lilongwe"},{"MALI", "Bamako"}, {"MAURITANIA", "Nouakchott"},{"MAURITIUS", "Port Louis"}, {"MOROCCO", "Rabat"},
            {"MOZAMBIQUE", "Maputo"}, {"NAMIBIA", "Windhoek"},{"NIGER", "Niamey"}, {"NIGERIA", "Abuja"},{"RWANDA", "Kigali"},{"SAO TOME E PRINCIPE","Sao Tome"},
            {"SENEGAL", "Dakar"}, {"SEYCHELLES", "Victoria"},{"SOUTH AFRICA","Pretoria/Cape Town"},{"SUDAN","Khartoum"},{"SWAZILAND", "Mbabane"},
            {"TANZANIA", "Dodoma"},{"TOGO","Lome"}, {"TUNISIA", "Tunis"}, {"UGANDA" ,"Kampala"},{"DEMOCRATIC REPUBLIC OF THE CONGO", "Kinshasa"},
            {"ZAMBIA", "Lusaka"}, {"ZIMBABWE", "Harare"},
            //Asia
            {"AFGHANISTAN", "Kabul"}, {"BAHRAIN", "Manama"},{"BANGLADESH", "Dhaka"}, {"BHUTAN", "Thimphu"},
            {"BRUNEI","Bandar Seri Begawan"},{ "CAMBODIA", "Phnom Penh"},{"CHINA", "Beijing"}, {"CYPRUS", "Nicosia"},{"INDIA" ,"New Delhi"},
            {"INDONESIA", "Jakarta"}, {"IRAN", "Tehran"}, {"IRAQ", "Baghdad"},{"ISRAEL", "Tel Aviv"}, {"JAPAN", "Tokyo"},{"JORDAN", "Amman"}, {"KUWAIT", "Kuwait City"},
            {"LAOS", "Vientiane"}, {"LEBANON", "Beirut"},{"MALAYSIA", "Kuala Lumpur"}, {"THE MALDIVES", "Male"},{"MONGOLIA", "Ulan Bator"},{"MYANMAR (BURMA)", "Rangoon"},
            {"NEPAL", "Katmandu"}, {"NORTH KOREA", "P'yongyang"},{ "OMAN", "Muscat"}, {"PAKISTAN", "Islamabad"},{"PHILIPPINES", "Manila"}, {"QATAR", "Doha"},
            {"SAUDI ARABIA", "Riyadh"}, {"SINGAPORE","Singapore"},{"SOUTH KOREA", "Seoul"}, {"SRI LANKA", "Colombo"},{"SYRIA", "Damascus"},{"TAIWAN (REPUBLIC OF CHINA)", "Taipei"},
            {"THAILAND", "Bangkok"}, {"TURKEY", "Ankara"},{"UNITED ARAB EMIRATES", "Abu Dhabi"},{"VIETNAM", "Hanoi"}, {"YEMEN", "Sana'a"},

            //Australia and Oceania
            {"AUSTRALIA", "Canberra"}, {"FIJI", "Suva"},{"KIRIBATI", "Bairiki"},{"MARSHALL ISLANDS", "Dalap-Uliga-Darrit"},
            {"MICRONESIA", "Palikir"}, {"NAURU", "Yaren"},{"NEW ZEALAND", "Wellington"}, {"PALAU", "Koror"},{"PAPUA NEW GUINEA", "Port Moresby"},
            {"SOLOMON ISLANDS", "Honaira"}, {"TONGA", "Nuku'alofa"},{"TUVALU", "Fongafale"}, {"VANUATU","Port-Vila"},{"WESTERN SAMOA", "Apia"},

            // Eastern Europe and former USSR
            {"ARMENIA", "Yerevan"},{"AZERBAIJAN", "Baku"},{"BELARUS", "Minsk"},{"GEORGIA", "Tbilisi"}, {"KAZAKSTAN", "Almaty"}, {"KYRGYZSTAN", "Alma-Ata"},
            {"MOLDOVA", "Chisinau"}, {"RUSSIA", "Moscow"},{"TAJIKISTAN", "Dushanbe"}, {"TURKMENISTAN", "Ashkabad"},{"UKRAINE", "Kyiv"}, {"UZBEKISTAN", "Tashkent"},
            // Europe
            {"ALBANIA", "Tirana"}, {"ANDORRA", "Andorra la Vella"},{"AUSTRIA", "Vienna"}, {"BELGIUM", "Brussels"},{"BOSNIA HERZEGOVINA", "Sarajevo"},
            {"CROATIA", "Zagreb"}, {"CZECH REPUBLIC","Prague"},{"DENMARK", "Copenhagen"}, {"ESTONIA", "Tallinn"},{"FINLAND", "Helsinki"}, {"FRANCE","Paris"},
            {"GERMANY", "Berlin"}, {"GREECE", "Athens"},{"HUNGARY", "Budapest"}, {"ICELAND", "Reykjavik"},{"IRELAND", "Dublin"}, {"ITALY", "Rome"},
            {"LATVIA", "Riga"}, {"LIECHTENSTEIN", "Vaduz"},{"LITHUANIA", "Vilnius"}, {"LUXEMBOURG", "Luxembourg"},{"MACEDONIA", "Skopje"}, {"MALTA", "Valletta"},
            {"MONACO", "Monaco"}, {"MONTENEGRO", "Podgorica"},{"THE NETHERLANDS", "Amsterdam"}, {"NORWAY", "Oslo"},{"POLAND", "Warsaw"}, {"PORTUGAL", "Lisbon"},
            {"ROMANIA", "Bucharest"}, {"SAN MARINO", "San Marino"},{"SERBIA", "Belgrade"}, {"SLOVAKIA", "Bratislava"},{"SLOVENIA", "Ljujiana"}, {"SPAIN", "Madrid"},
            {"SWEDEN","Stockholm"}, {"SWITZERLAND", "Berne"},
            {"UNITED KINGDOM", "London"},


            // North and Central America
            {"ANTIGUA AND BARBUDA", "Saint John's"},{"BAHAMAS", "Nassau"},{"BARBADOS", "Bridgetown"}, {"BELIZE", "Belmopan"},{"CANADA", "Ottawa"}, {"COSTA RICA", "San Jose"},
            {"CUBA", "Havana"}, {"DOMINICA", "Roseau"},{ "DOMINICAN REPUBLIC", "Santo Domingo"},{"EL SALVADOR", "San Salvador"},{"GRENADA", "Saint George's"},
            {"GUATEMALA", "Guatemala City"},{"HAITI", "Port-au-Prince"},{ "HONDURAS", "Tegucigalpa"}, {"JAMAICA", "Kingston"},{"MEXICO", "Mexico City"}, {"NICARAGUA", "Managua"},
            {"PANAMA", "Panama City"}, {"NEVIS", "Basseterre"}, {"ST. LUCIA", "Castries"}, {"ST. VINCENT AND THE GRENADINES", "Kingstown"}, { "UNITED STATES OF AMERICA", "Washington, D.C."},
            // South America
            {"ARGENTINA" , "Buenos Aires"}, {"BOLIVIA", "Sucre (legal)/La Paz(administrative)"}, {"BRAZIL", "Brasilia"}, {"CHILE","Santiago"},
            {"COLOMBIA", "Bogota"}, {"ECUADOR", "Quito"}, {"GUYANA", "Georgetown"}, {"PARAGUAY", "Asuncion"}, {"PERU", "Lima"}, {"SURINAME", "Paramaribo"},
            {"TRINIDAD AND TOBAGO", "Port of Spain"}, {"URUGUAY", "Montevideo"}, {"VENEZUELA", "Caracas"},
    };


    //// Calculate the hash key
    public int findStringHashKey(String val){

        int hashKey =0;
        //for example a country like BOSNIA HERZEGOVINA --> this method will return bosniaherzegovina
        //if we keep capitals and spaces or any other dashes or any other symbols, the ascii code of those might cause the hashKey to be a negative value
        val = removeSpace(val);
        for(int i=0; i< val.length(); i++){
            hashKey = (hashKey * 27 + (val.charAt(i) - 96)) % arraySize;
        }
        //the value of this haskey will always be between 0 - the arraySize
        return hashKey;
    }

    //Constructor
    public Countries_Capital(int size){
        this.arraySize = size;
        this.listOfCountries = new CountryLinkedList[size];
        for(int i =0; i< size ; i++){

            listOfCountries[i] = new CountryLinkedList();

        }
        add2DArray();
    }

    //Insert a country to the Hash
    public void insert(Country newCountry){
        String countryName = newCountry.getName();
        //calculating the Hash of the Word
        int hashKey = findStringHashKey(countryName);

        //Adding the new country to the Array and set the key of that country
        listOfCountries[hashKey].insertCountryToList(newCountry);

    }


    //Adding the 2D array in the hashMap
    private void add2DArray() {

        for (String[] pairsCountry : pairsCountries) {
            String countryName = pairsCountry[0];
            String capitalName = pairsCountry[1];

            Country newCountry = new Country(countryName, capitalName);

            insert(newCountry);

        }


    }
    //this method remove Space, and the single quotation of the String
    private String removeSpace(String text){
       return text.toLowerCase().replaceAll("\\s","").replaceAll("'","");
    }


    //search countries
    public  Country searchCountry(String country){
        int hashKey = findStringHashKey(country);
        return listOfCountries[hashKey].findCountry(country);
    }

    //display all the countries
    public void displayAllCountries (){
        for(int i = 0; i< arraySize; i++){
            System.out.println("Index : "+ i);
            listOfCountries[i].displayCountryList();

        }

    }




}

