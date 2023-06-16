import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NationManager {


    public static void main(String[] args) {
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
                    "WHERE c.name LIKE ? \n" +
                    "ORDER BY c.name ";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, "%" + in + "%");

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
            System.out.println("Errore durante l'esecuzione della query.");
        }

        for (int i = 0; i < listaNazioni.size(); i++) {
            System.out.println(listaNazioni.get(i).toString());
        }


        System.out.print("Scegli l'id di un country: ");
        int id = scan.nextInt();
        ArrayList<String> listaLanguage = new ArrayList<>();
        NationStat stat = null;


        String query2 = "SELECT DISTINCT c.name, l.language, cs.`year`, cs.population, cs.gdp\n" +
                "FROM countries c\n" +
                "JOIN country_stats cs ON cs.country_id = c.country_id\n" +
                "JOIN country_languages cl ON cl.country_id = c.country_id\n" +
                "JOIN languages l ON l.language_id = cl.language_id\n" +
                "WHERE c.country_id = ? \n" +
                "AND cs.`year` = (\n" +
                "  SELECT MAX(`year`)\n" +
                "  FROM country_stats\n" +
                "  WHERE country_id = c.country_id\n" +
                ")";
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            try (PreparedStatement ps = con.prepareStatement(query2)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nameCountry = rs.getString(1);
                        String language = rs.getString(2);
                        int year = rs.getInt(3);
                        int population = rs.getInt(4);
                        BigDecimal gdb = rs.getBigDecimal(5);

                        listaLanguage.add(language);
                        stat = new NationStat(nameCountry, listaLanguage, year, population, gdb);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("nonp osdoa");
        }

        System.out.println(stat.toString());
    }
}
