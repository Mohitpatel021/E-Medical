package com.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.medicine.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query("SELECT a FROM Admin a WHERE a.adminid = ?1 and a.password = ?2")
    public Admin validateAdmin(int adminid, String password);

    public Optional<Admin> findByPassword(String password);
}
