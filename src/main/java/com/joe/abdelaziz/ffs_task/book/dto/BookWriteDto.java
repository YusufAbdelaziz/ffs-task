package com.joe.abdelaziz.ffs_task.book.dto;

import com.joe.abdelaziz.ffs_task.book.BookType;
import com.joe.abdelaziz.ffs_task.utils.validators.bookTypeValidator.ValidEnum;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookWriteDto {
  @Size(max = 200)
  @NotEmpty
  private String name;

  @Min(1)
  @NotNull
  private Long authorId;

  @ValidEnum(enumClass = BookType.class, message = "Invalid book type, you should provide one of values (Science, History, Fiction)")
  private BookType type;
}
