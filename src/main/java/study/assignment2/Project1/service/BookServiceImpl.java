package study.assignment2.Project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.assignment2.Project1.dao.BookRepository;
import study.assignment2.Project1.dto.BookDto;
import study.assignment2.Project1.model.BookEntity;

import java.util.ArrayList;
import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntityList;
        bookEntityList = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (BookEntity bookEntity :
                bookEntityList) {
            BookDto bookDto = new BookDto(bookEntity);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public void addBook(BookDto bookDto) {
        BookEntity bookEntity = createBook(bookDto);
        bookRepository.save(bookEntity);
    }

    @Override
    public void addMultipleBooks(List<BookDto> bookDtos) {
        List<BookEntity> bookEntityList = createBookList(bookDtos);
        bookRepository.saveAll(bookEntityList);
    }

    @Override
    public void updateAuthorName(String prevoiusName, String updatedName) {
        bookRepository.updateAuthorName(prevoiusName + " ", updatedName);
    }

    @Override
    public void deleteBooksCostlierThan(Integer cost) {
        bookRepository.deleteBooksCostlierThan(cost);
    }

    private BookEntity createBook(BookDto bookDto) {
        return new BookEntity(bookDto.getName(), bookDto.getAuthorName(), bookDto.getCost());
    }

    private List<BookEntity> createBookList(List<BookDto> bookDtos) {
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (BookDto bookDto :
                bookDtos) {
            bookEntityList.add(createBook(bookDto));

        }
        return bookEntityList;
    }
}
