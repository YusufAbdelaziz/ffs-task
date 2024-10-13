package com.joe.abdelaziz.ffs_task.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joe.abdelaziz.ffs_task.author.Author;
import com.joe.abdelaziz.ffs_task.author.service.AuthorService;
import com.joe.abdelaziz.ffs_task.book.Book;
import com.joe.abdelaziz.ffs_task.book.BookType;
import com.joe.abdelaziz.ffs_task.book.dto.BookReadDto;
import com.joe.abdelaziz.ffs_task.book.dto.BookWriteDto;
import com.joe.abdelaziz.ffs_task.book.mapper.BookMapper;
import com.joe.abdelaziz.ffs_task.book.repository.BookRepository;
import com.joe.abdelaziz.ffs_task.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BookService {

  private BookRepository bookRepository;
  private BookMapper bookMapper;
  private AuthorService authorService;

  public BookReadDto fetchBookDtoById(Long id) {
    return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Book", id)));
  }

  private Book fetchBookById(Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Book", id));
  }

  public List<BookReadDto> fetchAllBooks() {
    return bookRepository.findBooksWithAuthors().stream().map(book -> bookMapper.toDto(book)).toList();
  }

  public List<BookReadDto> fetchBooksByType(BookType type) {
    return bookRepository.findByType(type).stream().map(book -> bookMapper.toDto(book)).toList();
  }

  @Transactional
  public BookReadDto createBook(BookWriteDto dto) {
    Author author = authorService.findAuthorById(dto.getAuthorId());
    Book newBook = bookMapper.mapForCreating(dto);
    newBook.setAuthor(author);
    bookRepository.save(newBook);
    return bookMapper.toDto(newBook);
  }

  @Transactional
  public BookReadDto updateBook(Long id, BookWriteDto dto) {
    Book existingBook = fetchBookById(id);

    // Fetch the new author if the dto's author id is different than the existing
    // one.
    if (dto.getAuthorId() != null && !existingBook.getAuthor().getId().equals(dto.getAuthorId())) {
      Author author = authorService.findAuthorById(dto.getAuthorId());
      existingBook.setAuthor(author);
    }
    bookMapper.mapForUpdating(existingBook, dto);

    return bookMapper.toDto(bookRepository.save(existingBook));
  }

  @Transactional
  public void removeBook(Long id) {
    // To check if a book record is found.
    Book book = fetchBookById(id);
    bookRepository.delete(book);
  }
}
