package com.ewhaenonymous.ttockclinic;

import com.ewhaenonymous.ttockclinic.domain.Clinic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends CrudRepository<Clinic, Long> {
    Optional<Clinic> findById(Long id);

    @Query(value = "select * from clinic where si_do = ?1 and (si_gun_gu like %?2%);", nativeQuery = true)
    List<Clinic> findBySiDoAndSiGunGuContaining(String siDo, String siGunGu); //확인하기!
}
