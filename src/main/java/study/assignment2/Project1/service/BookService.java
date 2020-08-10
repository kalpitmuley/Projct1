package study.assignment2.Project1.service;

import study.assignment2.Project1.dto.BookDto;

import java.util.List;


public interface BookService {

    /**
     * @return All the books stored in the DB
     */
    List<BookDto> getAllBooks();

    /**
     * Add a book to the Database
     *
     * @param bookDto Book to be added
     */
    void addBook(BookDto bookDto);

    /**
     * Add List of books in the Database
     *
     * @param bookDtos List of books
     */
    void addMultipleBooks(List<BookDto> bookDtos);

    /**
     * Update the AuthorName to updatedName if the the first name uthor name is prevoiusName
     *
     * @param prevoiusName First name of the Author
     * @param updatedName  New name of the Author
     * @return Number of entries modified
     */
    Integer updateAuthorName(String prevoiusName, String updatedName);

    /**
     * Delete the Books whose cost is more than @param cost
     *
     * @param cost Cost of the book
     * @return Number of entries deleted
     */
    Integer deleteBooksCostlierThan(Integer cost);
}
