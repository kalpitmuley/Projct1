package study.assignment2.Project1.service;

import study.assignment2.Project1.dto.BookDto;

import java.util.List;


public interface BookService {

    List<BookDto> getAllBooks();

    void addBook(BookDto bookDto);

    void addMultipleBooks(List<BookDto> bookDtos);

    void updateAuthorName(String prevoiusName, String updatedName);

    void deleteBooksCostlierThan(Integer cost);
}
