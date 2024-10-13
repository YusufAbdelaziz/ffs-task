package com.joe.abdelaziz.ffs_task.book.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.abdelaziz.ffs_task.book.dto.BookReadDto;
import com.joe.abdelaziz.ffs_task.book.dto.BookWriteDto;
import com.joe.abdelaziz.ffs_task.book.service.BookService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/{id}")
  public ResponseEntity<BookReadDto> getBookById(@PathVariable Long id) {
    BookReadDto book = bookService.fetchBookDtoById(id);
    return ResponseEntity.ok(book);
  }

  @GetMapping
  public ResponseEntity<List<BookReadDto>> getAllBooks() {
    List<BookReadDto> books = bookService.fetchAllBooks();
    return ResponseEntity.ok(books);
  }

  @PostMapping
  public ResponseEntity<BookReadDto> createBook(@RequestBody @Valid BookWriteDto bookCreateDto) {
    BookReadDto createdBook = bookService.createBook(bookCreateDto);
    return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookReadDto> updateBook(@Min(1) @PathVariable Long id,
      @RequestBody @Valid BookWriteDto bookUpdateDto) {

    BookReadDto updatedBook = bookService.updateBook(id, bookUpdateDto);
    return ResponseEntity.ok(updatedBook);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.removeBook(id);
    return ResponseEntity.noContent().build();
  }
}
