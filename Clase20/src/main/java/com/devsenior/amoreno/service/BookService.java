package com.devsenior.amoreno.service;

import com.devsenior.amoreno.exception.NotFoundException;
import com.devsenior.amoreno.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<Book> books;

    public BookService (){
        books = new ArrayList<>();
    }

    public void addBook(String isbn, String title, String author){
        books.add(new Book(isbn, title, author));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookByIsbn(String isbn) throws NotFoundException{
        for (var book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new NotFoundException("no fue encontrado el libro con isbn: " + isbn);
    }

    public void deleteBook(String isbn) throws NotFoundException{
        for (var book: books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return;
            }
        }
        throw new NotFoundException("no se puede eliminar el libro con isbn: " + isbn);
    }

}
