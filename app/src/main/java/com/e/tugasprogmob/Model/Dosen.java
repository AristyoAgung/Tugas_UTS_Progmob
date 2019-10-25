package com.e.tugasprogmob.Model;

public class Dosen {
    private String NIDN;
    private String gelar;
    private String email;
    private String alamat;

    public Dosen(String NIDN, String gelar, String email, String alamat) {
        this.NIDN = NIDN;
        this.gelar = gelar;
        this.email = email;
        this.alamat = alamat;
    }

    public String getNIDN() {
        return NIDN;
    }

    public void setNIDN(String NIDN) {
        this.NIDN = NIDN;
    }

    public String getGelar() {
        return gelar;
    }

    public void setGelar(String gelar) {
        this.gelar = gelar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
