package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private ArrayList<Incident> incidents = new ArrayList<>();
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Membre membre = (Membre) obj;
        return identifiant != null && identifiant.equals(membre.identifiant);
    }

    @Override
    public int hashCode() {
        return identifiant != null ? identifiant.hashCode() : 0;
    }

}
