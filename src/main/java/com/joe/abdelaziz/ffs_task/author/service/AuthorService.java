package com.joe.abdelaziz.ffs_task.author.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joe.abdelaziz.ffs_task.author.Author;
import com.joe.abdelaziz.ffs_task.author.repository.AuthorRepository;
import com.joe.abdelaziz.ffs_task.exception.RecordNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorService {

  private AuthorRepository authorRepository;

  public Author findAuthorById(Long id) {
    return (authorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Author", id)));

  }

  public List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public void createAuthor(Author author) {
    authorRepository.save(author);
  }
}
