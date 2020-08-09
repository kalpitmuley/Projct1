package study.assignment2.Project1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.assignment2.Project1.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("update Book b set b.authorName = :updatedName where b.authorName like :previousName%")
    void updateAuthorName(String previousName, String updatedName);

    @Query("DELETE Book b WHERE b.cost > :cost")
    void deleteBooksCostlierThan(Integer cost);
}
