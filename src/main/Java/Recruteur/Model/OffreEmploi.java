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

    // Getters et Setters
    public int getOf
