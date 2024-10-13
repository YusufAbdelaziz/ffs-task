package com.joe.abdelaziz.ffs_task.book.report;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.abdelaziz.ffs_task.book.BookType;
import com.joe.abdelaziz.ffs_task.book.service.BookService;
import com.joe.abdelaziz.ffs_task.utils.jasper.JasperReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {

  @Autowired
  BookService bookService;

  @Autowired
  JasperReportService jasperReportService;

  @GetMapping("/api/v1/book-report")
  public ResponseEntity<ByteArrayResource> getItemReport(@RequestParam String format, @RequestParam BookType type)
      throws JRException, IOException {

    byte[] reportContent = jasperReportService.getBookReport(bookService.fetchBooksByType(type), format);

    ByteArrayResource resource = new ByteArrayResource(reportContent);

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .contentLength(resource.contentLength())
        .header(HttpHeaders.CONTENT_DISPOSITION,
            ContentDisposition.attachment()
                .filename("book-report." + format)
                .build().toString())
        .body(resource);
  }
}
