package com.planningInspectorate.DataLayer;

import javax.persistence.*;

@Entity(name = "Department")
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private long id;
    private long organisationId; // foreign key - organisation table
    private String name;
    private String test; // stored as text rather than varchar
    private String notes; // stored as text rather than varchar
    private String location;

    public Department(){}

    // when reading from the database
    public Department(long id,
                      long organisationId,
                      String name,
                      String test,
                      String notes,
                      String location) {
        this.id = id;
        this.organisationId = organisationId;
        this.name = name;
        this.test = test;
        this.notes = notes;
        this.location = location;
    }

    // when writing to the database
    public Department(long organisationId, String name, String test, String notes, String location) {
        this.organisationId = organisationId;
        this.name = name;
        this.test = test;
        this.notes = notes;
        this.location = location;
    }

    public Department(long organisationId, String name, String test, String notes) {
        this.organisationId = organisationId;
        this.name = name;
        this.test = test;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", organisationId=" + organisationId +
                ", name='" + name + '\'' +
                ", test='" + test + '\'' +
                ", notes='" + notes + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
