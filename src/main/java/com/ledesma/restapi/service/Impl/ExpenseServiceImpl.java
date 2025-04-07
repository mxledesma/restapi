package com.ledesma.restapi.service.Impl;

import com.ledesma.restapi.dto.ExpenseDTO;
import com.ledesma.restapi.entity.ExpenseEntity;
import com.ledesma.restapi.repository.ExpenseRepository;
import com.ledesma.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  Service Implementation for Expense Model
 *  @author Michael Ledesma
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    /*
    The @RequiredArgsConstructor (from Lombok) generates a constructor that initializes all final fields.
    look at infoFinalandRequiredArgsConstructor
    with @RequiredArgsConstructor and final you don't need @Autowired
     */
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /**
     * Fetching the expenses from database
     * @return list
     */
    @Override
    public List<ExpenseDTO> getAllExpenses() {

        // Call the repository method and find all expenses from DB

        List<ExpenseEntity> list = expenseRepository.findAll();

        log.info("Printing the data from Repository {}", list);

        // Convert the Entity object to DTO object starts with stream() method
        // use map method to convert from expenseEntity to an expenseDTO to send to front end or client
        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());


        // Return list
        return listOfExpenses;
    }

    /**
     * Model Mapper to convert ExpenseEntity to Expense DTO
     * @param expenseEntity
     * @return ExpenseDTO
     */

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {

        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
