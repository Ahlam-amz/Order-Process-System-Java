package org.example.DAO;

import org.example.model.Incident;

import java.util.Set;

public interface IncidentDao {
    void inserer(Incident incident);
    void inserer(Set<Incident> incidents);
}
