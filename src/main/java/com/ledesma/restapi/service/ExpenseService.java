package com.ledesma.restapi.service;

import com.ledesma.restapi.dto.ExpenseDTO;

import java.util.List;

/**
 *  Service Interface for Expense Model
 *  @author Michael Ledesma
 */
public interface ExpenseService {

    /**
     *
     * Fetching a list of Expenses from database
     * @return List Expenses
     */

    List<ExpenseDTO> getAllExpenses();
}
