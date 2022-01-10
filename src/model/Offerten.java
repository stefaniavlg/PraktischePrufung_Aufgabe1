package model;

public class Offerten {

    private int id;
    private String unternehmensname;
    private int preis;
    private float mehrwertsteuer;
    private String adresse;
    private Ort ort;

    public Offerten(int id, String unternehmensname, int preis, float mehrwertsteuer, String adresse, Ort ort) {
        this.id = id;
        this.unternehmensname = unternehmensname;
        this.preis = preis;
        this.mehrwertsteuer = mehrwertsteuer;
        this.adresse = adresse;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnternehmensname() {
        return unternehmensname;
    }

    public void setUnternehmensname(String unternehmensname) {
        this.unternehmensname = unternehmensname;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public float getMehrwertsteuer() {
        return mehrwertsteuer;
    }

    public void setMehrwertsteuer(float mehrwertsteuer) {
        this.mehrwertsteuer = mehrwertsteuer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return  id +
                "&" + unternehmensname +
                "&" + preis +
                "&" + mehrwertsteuer +
                "&" + adresse +
                '&' + ort;
    }
}
