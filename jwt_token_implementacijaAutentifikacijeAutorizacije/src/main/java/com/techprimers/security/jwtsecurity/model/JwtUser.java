package com.techprimers.security.jwtsecurity.model;

public class JwtUser {
    private String korisnickoIme;
    private long idKorisnika;
    private String uloga;

    public void setUserName(String userName) {
        this.korisnickoIme = userName;
    }

    public void setId(long id) {
        this.idKorisnika = id;
    }

    public void setRole(String role) {
        this.uloga = role;
    }

    public String getUserName() {
        return korisnickoIme;
    }

    public long getId() {
        return idKorisnika;
    }

    public String getRole() {
        return uloga;
    }
}
