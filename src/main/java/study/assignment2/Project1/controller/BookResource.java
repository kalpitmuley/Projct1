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

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/server/port")
    public String getServerPort() {
        logger.info("Server port API returned port: " + serverPort);
        String result = "Server is running on port: "+serverPort;
        return result;
    }

    @GetMapping("/book/all")
    public List<BookDto> getAllBooks() {
        List<BookDto> bookList = bookService.getAllBooks();
        logger.info("List returned " + bookList.size() + " books");
        return bookList;
    }

    @PostMapping("/book/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookDto bookDto) {
        logger.info("Added book: " + bookDto);
        bookService.addBook(bookDto);
    }

    @PutMapping("/book/updateAuthor")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAuthorName(@RequestParam(value = "previousName", required = false, defaultValue = "Will") String previousName,
                                 @RequestParam(value = "UpdatedName", required = false, defaultValue = "Williams") String updatedName) {
        logger.info("Updating the Author name from" +previousName +" to " +updatedName);
        bookService.updateAuthorName(previousName, updatedName);
    }

    @DeleteMapping("/book/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBooksCostlierThan(@RequestParam(value = "cost", required = false, defaultValue = "1000") Integer cost) {
        logger.info("Deleting books costlier than: "+cost);
        bookService.deleteBooksCostlierThan(cost);
    }

}
