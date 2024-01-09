package com.felipe.DsList.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.DsList.Entities.Belonging;
import com.felipe.DsList.Entities.BelongingPK;

public interface BelongingRepository extends JpaRepository<Belonging, BelongingPK>{

}
