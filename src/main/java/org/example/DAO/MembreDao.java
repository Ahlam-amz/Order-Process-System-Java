package org.example.DAO;

import org.example.model.Incident;
import org.example.model.Membre;

import java.util.Set;

public interface MembreDao {
    void inserer(Membre membre);
    Set<Incident> chargerListIncidents(String membreIdentifiant);
}
