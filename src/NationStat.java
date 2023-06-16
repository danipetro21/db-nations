import java.math.BigDecimal;
import java.util.ArrayList;

public class NationStat {
    private String countryName;
    private ArrayList<String> listaLanguage;

    private int year;
    private int population;
    private BigDecimal gdb;


    public NationStat(String countryName, ArrayList<String> listaLanguage, int year, int population, BigDecimal gdb) {
        this.countryName = countryName;
        this.listaLanguage = listaLanguage;
        this.year = year;
        this.population = population;
        this.gdb = gdb;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<String> getListaLanguage() {
        return listaLanguage;
    }

    public void setListaLanguage(ArrayList<String> listaLanguage) {
        this.listaLanguage = listaLanguage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public BigDecimal getGdb() {
        return gdb;
    }

    public void setGdb(BigDecimal gdb) {
        this.gdb = gdb;
    }

    @Override
    public String toString() {

        return "Details for country: " + countryName + "\n" + "Languages: " + listaLanguage + "\n" + "Most recent stats" + "\n" + "Year: " + year + "\n" + "Population: " + population + "\n" + "GDB: " + gdb;
    }
}
