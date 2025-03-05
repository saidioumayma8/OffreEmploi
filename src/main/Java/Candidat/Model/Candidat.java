package Candidat.Model;

public class Candidat {
    private int id;
    private String nom;
    private String email;
    private String password;
    private String tel;
    private String cv;


    public Candidat() {}

    public Candidat(int id, String nom, String email, String password, String tel, String cv) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.cv = cv;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }
}

