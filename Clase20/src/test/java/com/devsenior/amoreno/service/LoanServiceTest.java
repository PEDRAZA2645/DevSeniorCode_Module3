package com.devsenior.amoreno.service;

import com.devsenior.amoreno.exception.NotFoundException;
import com.devsenior.amoreno.model.Book;
import com.devsenior.amoreno.model.LoanState;
import com.devsenior.amoreno.model.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoanServiceTest {

    private BookService bookService;
    private UserService userService;
    private LoanService service;

    @BeforeEach
    void setup() {
        bookService = Mockito.mock(BookService.class);
        userService = Mockito.mock(UserService.class);
        service = new LoanService(bookService, userService);
    }

    @DisplayName("Agregar un prestamo con usuario y libro existente")
    @Test
    void testAddLoanWithExistingUserAndExistingBook() throws NotFoundException {
        // GIVEN
        var id = "123";
        var isbn = "1234567890";
        var mockUser = new User(id, "Andres", "andres@gmail.com");
        var mockBook = new Book(isbn, "Learnning Java", "Andres Moreno");

        Mockito.when(userService.getUserById(id)).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(isbn)).thenReturn(mockBook);

        // WHEN
        service.addLoan(id, isbn);

        // THEN
        var loans = service.getLoans();
        assertEquals(1, loans.size());

        var loan = loans.get(0);
        assertNotNull(loan.getUser());
        assertNotNull(loan.getBook());
        assertEquals(LoanState.STARTED, loan.getState());

    }

    @Test
    void testReturnBookWithExistingLoan() throws NotFoundException {
        // GIVEN
        var id = "123";
        var isbn = "1234567890";

        var userMock = new User(id, "Andres Doe", "andres@gmail.com");
        var bookMock = new Book(isbn, "Learnning JUnit", "Andres Moreno");

        Mockito.when(userService.getUserById(anyString())).thenReturn(userMock);
        Mockito.when(bookService.getBookByIsbn(anyString())).thenReturn(bookMock);

        service.addLoan(id, isbn);

        // WHEN
        service.returnBook(id, isbn);

        // THEN
        var loans = service.getLoans();
        assertEquals(1, loans.size());

        var loan = loans.getFirst();
        assertEquals(id, loan.getUser().getId());
        assertEquals(isbn, loan.getBook().getIsbn());
        assertEquals(LoanState.FINISHED, loan.getState());
    }

    @Test
    void testReturnBookWithNonExistingLoan() {
        // GIVEN
        var id = "123";
        var isbn = "1234567890";

        // WHEN y THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.returnBook(id, isbn);
                });
    }
}