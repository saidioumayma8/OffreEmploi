package Recruteur.Model;

import java.util.Date;

public class OffreEmploi {
    private int offreId;
    private String titre;
    private String description;
    private Date datePublication;
    private int recruiterId;

    // Constructeurs
    public OffreEmploi(String titre, int offreId, Date datePublication, String description, int recruiterId) {
        this.titre = titre;
        this.offreId = offreId;
        this.datePublication = datePublication;
        this.description = description;
        this.recruiterId = recruiterId;
    }

    public OffreEmploi(int offreId, Object o, Object datePublication, Object description) {
    }

    public OffreEmploi() {
    }

    public int getOffreId() {
        return offreId;
    }

    public void setOffreId(int offreId) {
        this.offreId = offreId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }
}
