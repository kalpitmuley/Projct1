package study.assignment2.Project1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import study.assignment2.Project1.dto.BookDto;
import study.assignment2.Project1.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookResource {

    Logger logger = LoggerFactory.getLogger(BookResource.class);

    @Autowired
    BookService bookService;

    /**
     * Getting the port value from property file
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * @return Port on which server is running
     */
    @GetMapping("/server/port")
    public String getServerPort() {
        logger.info("Server port API returned port: " + serverPort);
        return "Server is running on port: " + serverPort;
    }

    /**
     * @return List of all the books in the DB
     */
    @GetMapping("/book/all")
    public List<BookDto> getAllBooks() {
        List<BookDto> bookList = bookService.getAllBooks();
        logger.info("List returned " + bookList.size() + " books");
        return bookList;
    }

    /**
     * API to add a book to the DB
     *
     * @param bookDto Book to be added
     */
    @PostMapping("/book/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookDto bookDto) {
        logger.info("Added book: " + bookDto);
        bookService.addBook(bookDto);
    }

    /**
     * API to add multiple books to the DB
     *
     * @param bookDtos List of books to be added
     * @return number of books added to the DB
     */
    @PostMapping("/book/addMultiple")
    @ResponseStatus(HttpStatus.CREATED)
    public String addMultipleBooks(@RequestBody List<BookDto> bookDtos) {
        logger.info("Adding " + bookDtos.size() + " books");
        bookService.addMultipleBooks(bookDtos);
        return bookDtos.size() + " Books Added to the DB";
    }

    /**
     * API to update the author name
     *
     * @param previousName Previous first name of the Author. Default value is Will
     * @param updatedName  Updated name of the Author. Default value is Williams
     * @return Number of Rows updated
     */
    @PutMapping("/book/updateAuthor")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateAuthorName(@RequestParam(value = "previousName", required = false, defaultValue = "Will") String previousName,
                                   @RequestParam(value = "newName", required = false, defaultValue = "Williams") String updatedName) {
        logger.info("Updating the Author name from" + previousName + " to " + updatedName);
        Integer updatedRows = bookService.updateAuthorName(previousName, updatedName);
        return updatedRows + " Rows updated";
    }

    /**
     * API to delete books which ccost more than given cost.
     *
     * @param cost cost of the book which needs to be deleted. Default value is 1000
     * @return Number of entries deleted
     */
    @DeleteMapping("/book/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBooksCostlierThan(@RequestParam(value = "cost", required = false, defaultValue = "1000") Integer cost) {
        logger.info("Deleting books costlier than: " + cost);
        Integer deletedRows = bookService.deleteBooksCostlierThan(cost);
        return deletedRows + " entries deleted";
    }

}
