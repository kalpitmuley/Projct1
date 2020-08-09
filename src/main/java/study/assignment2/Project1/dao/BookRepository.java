package study.assignment2.Project1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import study.assignment2.Project1.model.BookEntity;

import javax.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Modifying
    @Query("UPDATE Book b SET b.authorName = :updatedName WHERE b.authorName LIKE CONCAT(:previousName,' ','%') OR b.authorName LIKE :previousName")
    Integer updateAuthorName(String previousName, String updatedName);

    @Modifying
    @Query("DELETE Book b WHERE b.cost > :cost")
    Integer deleteBooksCostlierThan(Integer cost);
}