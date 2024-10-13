package com.joe.abdelaziz.ffs_task.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.abdelaziz.ffs_task.author.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
