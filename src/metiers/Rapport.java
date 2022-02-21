package metiers;

import java.util.Date;

public class Rapport {
    public Rapport(String matricule, Integer num_rapport, Integer num_praticien, Date date_rapport, String bilan_rapport, String motif_rapport, String medic_offert, Integer quantite) {
        super();
        this.matricule = matricule;
        this.num_rapport = num_rapport;
        this.num_praticien = num_praticien;
        this.date_rapport = date_rapport;
        this.bilan_rapport = bilan_rapport;
        this.motif_rapport = motif_rapport;
        this.medic_offert = medic_offert;
        this.quantite = quantite;

    }

    private String matricule;
    private Integer num_rapport;
    private Integer num_praticien;
    private Date date_rapport;
    private String bilan_rapport;
    private String motif_rapport;
    private String medic_offert;
    private Integer quantite;


    public String getMedic_offert() {
        return medic_offert;
    }

    public void setMedic_offert(String medic_offert) {
        this.medic_offert = medic_offert;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public Integer getNum_rapport() {
        return num_rapport;
    }
    public void setNum_rapport(Integer num_rapport) {
        this.num_rapport = num_rapport;
    }
    public Integer getNum_praticien() {
        return num_praticien;
    }
    public void setNum_praticien(Integer num_praticien) {
        this.num_praticien = num_praticien;
    }
    public Date getDate_rapport() {
        return date_rapport;
    }
    public void setDate_rapport(Date date_rapport) {
        this.date_rapport = date_rapport;
    }
    public String getBilan_rapport() {
        return bilan_rapport;
    }
    public void setBilan_rapport(String bilan_rapport) {
        this.bilan_rapport = bilan_rapport;
    }
    public String getMotif_rapport() {
        return motif_rapport;
    }
    public void setMotif_rapport(String motif_rapport) {
        this.motif_rapport = motif_rapport;
    }





}
