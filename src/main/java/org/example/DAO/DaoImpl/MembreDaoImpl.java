package org.example.DAO.DaoImpl;

import org.example.DAO.MembreDao;
import org.example.model.Incident;
import org.example.model.Membre;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MembreDaoImpl implements MembreDao {
    private HashMap<String, Member> membres = new HashMap<>();
    private HashMap<String, Set<Incident>> membreIncidents = new HashMap<>();

    @Override
    public void inserer(Membre membre) {
        membres.put(membre.getIdentifiant(), (Member) membre);
        membreIncidents.put(membre.getIdentifiant(), new HashSet<>());
    }

    @Override
    public Set<Incident> chargerListIncidents(String membreIdentifiant) {
        return membreIncidents.getOrDefault(membreIdentifiant, new HashSet<>());
    }
}
