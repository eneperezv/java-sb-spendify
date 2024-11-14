package com.enp.spendify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enp.spendify.api.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
