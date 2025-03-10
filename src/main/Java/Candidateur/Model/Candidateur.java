package Candidateur.Model;

import Recruteur.Model.OffreEmploi;
import Candidat.Model.Candidat;

public class Candidateur {

    public Candidateur() {

    }

    public enum CandidatureStatus {
        EN_ATTENTE, // Modifie ici si besoin
        ACCEPTEE,
        REFUSEE
    }

    public Candidateur(int candidatureId, Candidat candidate, OffreEmploi offreEmploi, CandidatureStatus status) {
        this.candidatureId = candidatureId;
        this.candidate = candidate;
        this.offreEmploi = offreEmploi;
        this.status = status;
    }

    private int candidatureId;
    private Candidat candidate;
    private OffreEmploi offreEmploi;
    private CandidatureStatus status;

    // Getters et setters
    public int getCandidatureId() {
        return candidatureId;
    }

    public void setCandidatureId(int candidatureId) {
        this.candidatureId = candidatureId;
    }

    public Candidat getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidat candidate) {
        this.candidate = candidate;
    }

    public OffreEmploi getOffreEmploi() {
        return offreEmploi;
    }

    public void setOffreEmploi(OffreEmploi offreEmploi) {
        this.offreEmploi = offreEmploi;
    }

    public CandidatureStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {
        try {
            this.status = CandidatureStatus.valueOf(status.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            System.err.println("Valeur inconnue pour CandidatureStatus : " + status);
            this.status = CandidatureStatus.EN_ATTENTE; // Valeur par défaut
        }
    }
}
