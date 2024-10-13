package com.joe.abdelaziz.ffs_task.book.dto;

import com.joe.abdelaziz.ffs_task.book.BookType;

import lombok.Data;

@Data
public class BookReadDto {

  private Long id;

  private String name;

  private String authorName;

  private BookType type;
}
