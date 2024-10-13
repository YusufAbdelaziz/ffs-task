package com.joe.abdelaziz.ffs_task.utils.jasper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.joe.abdelaziz.ffs_task.book.dto.BookReadDto;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JasperReportService {

  public byte[] getBookReport(List<BookReadDto> books, String format) throws JRException, IOException {
    JasperReport jasperReport;

    // Always look for the .jrxml file in the classpath
    try (InputStream reportInputStream = getClass().getResourceAsStream("/book-report.jrxml")) {
      if (reportInputStream == null) {
        throw new FileNotFoundException("Could not find book-report.jrxml in classpath");
      }
      jasperReport = JasperCompileManager.compileReport(reportInputStream);
    }

    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(books);
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("title", "Book Report");

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

    return switch (format.toLowerCase()) {
      case "pdf" -> JasperExportManager.exportReportToPdf(jasperPrint);
      case "xml" -> JasperExportManager.exportReportToXml(jasperPrint).getBytes();
      default -> throw new IllegalArgumentException("Unsupported report format: " + format);
    };
  }
}