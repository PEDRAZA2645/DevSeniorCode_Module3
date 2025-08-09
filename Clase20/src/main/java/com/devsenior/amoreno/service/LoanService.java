package com.devsenior.amoreno.service;

import com.devsenior.amoreno.exception.NotFoundException;
import com.devsenior.amoreno.model.Loan;
import com.devsenior.amoreno.model.LoanState;

import java.util.ArrayList;
import java.util.List;

public class LoanService {

    private List<Loan> loans;
    private BookService bookService;
    private UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loans = new ArrayList<>();
    }

    public void addLoan(String id, String isbn) throws NotFoundException {
        var user = userService.getUserById(id);
        var book = bookService.getBookByIsbn(isbn);
        loans.add(new Loan(user, book));
    }

    public void returnBook(String id, String isbn) throws NotFoundException {
        for (var loan : loans) {
            if (loan.getUser().getId().equals(id) && loan.getBook().getIsbn().equals(isbn) && loan.getLoanDate().equals(LoanState.STARTED)) {
                loan.setState(LoanState.FINISHED);
                return;
            }
        }
        throw new NotFoundException("No existe un prestamo del libro: " + isbn + " para el usuario: " + id);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
