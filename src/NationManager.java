import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NationManager {


    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:8889/db_nations";
        String user = "root";
        String password = "root";

        ArrayList<Nation> listaNazioni = new ArrayList<>();


        Scanner scan = new Scanner(System.in);
        System.out.print("inserisci un input di ricerca: ");
        String in = scan.nextLine();

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT c.name, c.country_id , r.name, c2.name \n" +
                    "FROM countries c \n" +
                    "JOIN regions r ON r.region_id = c.region_id \n" +
                    "JOIN continents c2 ON c2.continent_id = r.continent_id \n" +
                    "WHERE c.name LIKE '%" + in + "%'\n" +
                    "ORDER BY c.name ";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nameNation = rs.getString(1);
                        int idNation = rs.getInt(2);
                        String nameRegion = rs.getString(3);
                        String nameContinent = rs.getString(4);

                        Nation nazione = new Nation(nameNation, idNation, nameRegion, nameContinent);
                        listaNazioni.add(nazione);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("nonp osdoa");
        }

        for (int i = 0; i < listaNazioni.size(); i++) {
            System.out.println(listaNazioni.get(i).toString());
        }
    }
}
