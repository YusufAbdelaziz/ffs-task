package com.joe.abdelaziz.ffs_task.book.mapper;

import org.springframework.stereotype.Component;

import com.joe.abdelaziz.ffs_task.author.Author;
import com.joe.abdelaziz.ffs_task.book.Book;
import com.joe.abdelaziz.ffs_task.book.dto.BookReadDto;
import com.joe.abdelaziz.ffs_task.book.dto.BookWriteDto;

@Component
public class BookMapper {

  public Book mapForCreating(BookWriteDto dto) {
    if (dto == null) {
      return null;
    }

    Book book = new Book();
    book.setName(dto.getName());
    book.setType(dto.getType());

    if (dto.getAuthorId() != null) {
      Author author = new Author();
      author.setId(dto.getAuthorId());
      book.setAuthor(author);
    }

    return book;
  }

  public void mapForUpdating(Book book, BookWriteDto dto) {
    if (dto == null || book == null) {
      return;
    }

    if (dto.getName() != null) {
      book.setName(dto.getName());
    }
    if (dto.getType() != null) {
      book.setType(dto.getType());
    }
  }

  public BookReadDto toDto(Book entity) {
    if (entity == null) {
      return null;
    }

    BookReadDto dto = new BookReadDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setType(entity.getType());

    if (entity.getAuthor() != null) {
      dto.setAuthorName(entity.getAuthor().getName());
    }

    return dto;
  }

  public BookWriteDto toUpdateDto(Book entity) {
    if (entity == null) {
      return null;
    }

    BookWriteDto dto = new BookWriteDto();
    dto.setName(entity.getName());
    dto.setType(entity.getType());

    if (entity.getAuthor() != null) {
      dto.setAuthorId(entity.getAuthor().getId());
    }

    return dto;
  }

  public BookWriteDto toCreateDto(Book entity) {
    if (entity == null) {
      return null;
    }

    BookWriteDto dto = new BookWriteDto();
    dto.setName(entity.getName());
    dto.setType(entity.getType());

    if (entity.getAuthor() != null) {
      dto.setAuthorId(entity.getAuthor().getId());
    }

    return dto;
  }

  public Book fromId(Long id) {
    if (id == null) {
      return null;
    }
    Book book = new Book();
    book.setId(id);
    return book;
  }
}