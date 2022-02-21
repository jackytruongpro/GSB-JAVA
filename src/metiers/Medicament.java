package metiers;

public class Medicament {
    public Medicament(String nom, String code, String famille, String composition, String effets, String contre_indic, String prix) {
        super();
        this.nom = nom;
        this.code = code;
        this.famille = famille;
        this.composition = composition;
        this.effets = effets;
        this.contre_indic = contre_indic;
        this.prix = prix;

    }

    private String nom;
    private String code;
    private String famille;
    private String composition;
    private String effets;
    private String contre_indic;
    private String prix;

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public String getFamille() {
        return famille;
    }

    public String getComposition(){
        return composition;
    }

    public String getEffets(){
        return effets;
    }

    public String getContre_Indic(){
        return contre_indic;
    }

    public String getPrix(){
        return prix;
    }

}



