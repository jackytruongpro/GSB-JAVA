package metiers;

public class Visiteur {
    public Visiteur(String mat, String nom, String prenom, String addrs, String CP, String ville, String date, String labCode, String secCode) {
        super();
        this.mat = mat;
        this.nom = nom;
        this.prenom = prenom;
        this.addrs = addrs;
        this.CP = CP;
        this.ville = ville;
        this.date = date;
        this.labCode = labCode;
        this.secCode = secCode;

    }
    private String mat;
    private String nom;
    private String prenom;
    private String addrs;
    private String CP;
    private String ville;
    private String date;
    private String labCode;
    private String secCode;

    public String getMat() {
        return mat;
    }
    public void setMat(String mat) {
        this.mat = mat;
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getLabCode() {
        return labCode;
    }
    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }
    public String getSecCode() {
        return secCode;
    }
    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

}
