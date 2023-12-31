import java.util.ArrayList;

public class Nation {

    private String nameNation;
    private int idNation;
    private String nameRegion;
    private String nameContinent;


    public Nation(String nameNation, int idNation, String nameRegion, String nameContinent) {
        this.nameNation = nameNation;
        this.idNation = idNation;
        this.nameRegion = nameRegion;
        this.nameContinent = nameContinent;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }

    public int getIdNation() {
        return idNation;
    }

    public void setIdNation(int idNation) {
        this.idNation = idNation;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    public String getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(String nameContinent) {
        this.nameContinent = nameContinent;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "nameNation='" + nameNation + '\'' +
                ", idNation=" + idNation +
                ", nameRegion='" + nameRegion + '\'' +
                ", nameContinent='" + nameContinent + '\'' +
                '}';
    }


    //test tabella
    public static void printTableHeader() {
        System.out.format("+----+-------------+----------------+------------+%n");
        System.out.format("| ID |   COUNTRY   |     REGION     |  CONTINENT |%n");
        System.out.format("+----+-------------+----------------+------------+%n");
    }

    public void printTableRow() {
        System.out.format("| %-2d | %-11s | %-14s | %-10s |%n", idNation, nameNation, nameRegion, nameContinent);
    }

    public static void printTableFooter() {
        System.out.format("+----+-------------+----------------+------------+%n");
    }

    public static void jtable(ArrayList<Nation> nationStats) {
        printTableHeader();
        for (Nation nation : nationStats) {
            nation.printTableRow();
        }
        printTableFooter();
    }
}
