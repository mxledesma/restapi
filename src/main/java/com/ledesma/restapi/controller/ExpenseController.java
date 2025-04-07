package com.ledesma.restapi.controller;


import com.ledesma.restapi.dto.ExpenseDTO;
import com.ledesma.restapi.io.ExpenseResponse;
import com.ledesma.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

   /**
    *  This is controller class for Expense Model
    *  @author Michael Ledesma
   */

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;

    private final ModelMapper modelMapper;

    // The repository communicates to the DB
    // The serviceImpl communicates to the front end

    // Returns the List of ExpenseResponse to the DB

    /**
     *  Fetching the expenses from the database
     *  @return list
     */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){

        log.info("API Get /expenses called.");

        // Call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();

        log.info("Printing the data from Service {}", list);

        // Convert the ExpenseDTO to Expense Response
        List<ExpenseResponse> response = list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());

        // Return the list/response

        return response;

    }

    // to get ExpenseResponse to communicate to the DB

    /**
     *
     * Mapper method for convertering DTO objec to expense response
     * @param expenseDTO
     * @return ExpenseResponse
     */
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {

       return  modelMapper.map(expenseDTO, ExpenseResponse.class);

    }
}
