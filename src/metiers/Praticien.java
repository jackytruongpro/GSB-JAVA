package metiers;
public class Praticien {

    public Praticien(String num, String nom, String prenom, String addrs, String CP, String ville, String coef, String typCode) {
        super();
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.addrs = addrs;
        this.CP = CP;
        this.ville = ville;
        this.coef = coef;
        this.typCode = typCode;

    }
    private String num;
    private String nom;
    private String prenom;
    private String addrs;
    private String CP;
    private String ville;
    private String coef;
    private String typCode;

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getAddrs() {
        return addrs;
    }
    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }
    public String getCP() {
        return CP;
    }
    public void setCP(String cP) {
        CP = cP;
    }
    public String getLabCode() {
        return coef;
    }
    public void setLabCode(String coef) {
        this.coef = coef;
    }
    public String getSecCode() {
        return typCode;
    }
    public void setSecCode(String typCode) {
        this.typCode = typCode;
    }

}