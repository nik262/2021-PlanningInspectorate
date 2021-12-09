package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    @Modifying
    @Query(value="UPDATE organisation " +
            "SET name = ? " +
            "WHERE id = ?",
            nativeQuery = true)
    boolean updateOrg(String name, long orgId);

    @Query(value = "SELECT id, name FROM Organisation WHERE name = ?", nativeQuery = true)
    List<List<String>> getByName(String organisationName);

    @Query(value="INSERT INTO Organisation (name) " +
            "VALUES (?)",
            nativeQuery = true
    )
    boolean addOrg(String organisationName);
}
