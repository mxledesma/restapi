package com.ledesma.restapi.repository;

import com.ledesma.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {


}
