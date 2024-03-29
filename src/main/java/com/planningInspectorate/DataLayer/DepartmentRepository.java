package com.planningInspectorate.DataLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
            "FROM Department, Organisation, Contact, Person " +
            "WHERE Department.organisation_id = Organisation.id " +
            "AND Contact.department_id = Department.id " +
            "AND Person.id = Contact.person_id " +
            "AND Department.name LIKE ?",
            nativeQuery = true)
    List<List<String>> getRecordByDept(String field);

    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Organisation.name LIKE ?",
            nativeQuery = true)
    List<List<String>> getRecordByOrg(String field);

    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Department.test LIKE ?",
            nativeQuery = true)
    List<List<String>> getRecordByTest(String field);

    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Department.notes LIKE ?",
            nativeQuery = true)
    List<List<String>> getRecordByNotes(String field);

    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Person.method LIKE ?",
            nativeQuery = true)
    List<List<String>> getRecordByMethod(String field);

    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Person.name LIKE ?",
            nativeQuery = true)
    List<List<String>> getRecordByPerson(String field);

    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Person.email = ?",
            nativeQuery = true)
    List<List<String>> getRecordByEmail(String field);

    @Transactional
    @Modifying
    @Query(value =
            "UPDATE Department " +
                    "SET name = ?, notes = ?, organisation_id = ?, test= ? " +
                    "WHERE id = ?",
            nativeQuery = true)
    int updateDepartment(String name, String notes, Long orgId, String test, Long deptId);

    @Query(value =
            "SELECT Department.Id " +
                    "FROM Department, Organisation " +
                    "WHERE Department.name LIKE ? " +
                    "AND Organisation.id = ? " +
                    "AND Department.organisation_id = Organisation.id;",
            nativeQuery = true)
    List<String> getByName(String department, Long orgId);

    @Query(value= "INSERT INTO Department (name, organisation_id) VALUES (?, ?);", nativeQuery = true)
    boolean addDept(String department, Long orgId);


    @Query(value =
            "SELECT Contact.id,  Department.name AS \"DeptName\", Organisation.name AS \"OrgName\", Department.test, Department.notes, Person.method, Person.name AS \"PersName\", Person.email " +
                    "FROM Department, Organisation, Contact, Person " +
                    "WHERE Department.organisation_id = Organisation.id " +
                    "AND Contact.department_id = Department.id " +
                    "AND Person.id = Contact.person_id " +
                    "AND Contact.otp = ?",
            nativeQuery = true)
    List<String> getRecordFromOtp(String pin);
}
