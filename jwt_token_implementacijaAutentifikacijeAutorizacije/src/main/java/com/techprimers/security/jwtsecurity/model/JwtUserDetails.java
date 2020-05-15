package com.techprimers.security.jwtsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

    private String korisnickoIme;
    private String token;
    private Long idKorisnika;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(String userName, long idKorisnika, String token, List<GrantedAuthority> grantedAuthorities) {

        this.korisnickoIme = userName;
        this.idKorisnika = idKorisnika;
        this.token= token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return korisnickoIme;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getUserName() {
        return korisnickoIme;
    }

    public String getToken() {
        return token;
    }


    public Long getId() {
        return idKorisnika;
    }

}
