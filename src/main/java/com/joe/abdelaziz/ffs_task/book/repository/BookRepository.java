package com.joe.abdelaziz.ffs_task.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joe.abdelaziz.ffs_task.book.Book;
import com.joe.abdelaziz.ffs_task.book.BookType;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("SELECT b FROM Book b JOIN FETCH b.author")
  List<Book> findBooksWithAuthors();

  List<Book> findByType(BookType type);

  // List<Book> findByTypeOrderByNameAsc(BookType type);

}
