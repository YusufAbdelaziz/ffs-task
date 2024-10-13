package com.joe.abdelaziz.ffs_task.utils.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.joe.abdelaziz.ffs_task.author.Author;
import com.joe.abdelaziz.ffs_task.author.service.AuthorService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final AuthorService authorService;

  @Override
  public void run(String... args) throws Exception {
    // Insert some author records
    if (authorService.findAllAuthors().isEmpty()) {
      Author author1 = new Author(null, "George Orwell");
      Author author2 = new Author(null, "Jane Austen");
      Author author3 = new Author(null, "J.K. Rowling");

      authorService.createAuthor(author1);
      authorService.createAuthor(author2);
      authorService.createAuthor(author3);

      System.out.println("Authors have been inserted!");
    }
  }
}
