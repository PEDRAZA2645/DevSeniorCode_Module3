package com.devsenior.amoreno.service;

import com.devsenior.amoreno.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookService service;

    @BeforeEach
    void setup() {
        service = new BookService();
    }

    @Test
    void addBook() throws NotFoundException {
        //GIVEN - Preparar el escenario de prueba
        var isbn = "123456789";
        var title = "Learnning Java";
        var author = "Andres Moreno";
        //WHEN - Metodo a probar
        service.addBook(isbn, title, author);
        //THEN - Verificar el resultado esperado
        var book = service.getBookByIsbn(isbn);
        assertNotNull(book);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(isbn, book.getIsbn());
    }

    @Test
    void getAllBooks() {
    }

    @Test
    void getBookByIsbn() {
    }

    @Test
    void deleteBook() throws NotFoundException {
        //GIVEN - Preparar el escenario de prueba
        var isbn = "123456789";
        var title = "Learnning Java";
        var author = "Andres Moreno";
        service.addBook(isbn, title, author);
        //WHEN - Metodo a probar
        service.deleteBook(isbn);
        try {
            service.getBookByIsbn(isbn);
            fail();
        } catch (NotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    void testDeleteNonExistingBook() {
        // GIVEN
        var isbn = "123456789";

        // WHEN - THEN
        assertThrows(NotFoundException.class, () -> {
                    service.deleteBook(isbn);
                });
    }

    @Test
    void testDeleteWithExistingBooksButNotGivenIsbn() {
        // GIVEN
        service.addBook("9876543210", "En busca de la felicidad", "Cesar Diaz");
        var isbn = "1234567890";

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> service.deleteBook(isbn));
    }

    @Test
    void testGetAllBooks() {
        // GIVEN

        // WHEN
        var books = service.getAllBooks();

        // THEN
        assertNotNull(books);
        assertEquals(0, books.size());
    }

    @Test
    void testGetBookByIsbnWithWrongIsbn() {
        // GIVEN
        service.addBook("1234567890", "Buscando la felicidad", "Cesar Diaz");

        var isbn = "0987654321";

        // WHEN -THEN
        assertThrows(NotFoundException.class, () -> service.getBookByIsbn(isbn));
    }
}