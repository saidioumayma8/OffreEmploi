package Candidature.Model;

import Candidat.Model.Candidat;
import OffreEmploi.Model.OffreEmploi;

public class Candidature {
    private int candidatureId;
    private CandidatureStatus status;
    private Candidat candidate;
    private OffreEmploi offreEmploi;

    public enum CandidatureStatus {
        EN_ATTENTE, ACCEPTEE, REFUSEE
    }

    // Constructeurs
    public Candidature() {}

    public Candidature(int candidatureId, CandidatureStatus status, Candidat candidate, OffreEmploi offreEmploi) {
        this.candidatureId = candidatureId;
        this.status = status;
        this.candidate = candidate;
        this.offreEmploi = offreEmploi;
    }

    // Getters et Setters
    public int getCandidatureId() { return candidatureId; }
    public void setCandidatureId(int candidatureId) { this.candidatureId = candidatureId; }

    public CandidatureStatus getStatus() { return status; }
    public void setStatus(CandidatureStatus status) { this.status = status; }

    public Candidat getCandidate() { return candidate; }
    public void setCandidate(Candidat candidate) { this.candidate = candidate; }

    public OffreEmploi getOffreEmploi() { return offreEmploi; }
    public void setOffreEmploi(OffreEmploi offreEmploi) { this.offreEmploi = offreEmploi; }
}
