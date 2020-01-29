package comper;

public class Europa  implements Comparable<Europa>{
    private String country;
    private String capital;

    public Europa(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return "Europa{" +
                "country='" + country + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

    @Override
    public int compareTo(Europa o) {
        return country.compareTo(o.getCountry());
    }
}
