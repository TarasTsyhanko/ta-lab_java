package banksystem.entity;

public class ClientAccount {
    private int login;
    private  String parole;
    private int IDClient;

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getParole() {
        return parole;
    }

    public void setParole(String parole) {
        this.parole = parole;
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }
}
