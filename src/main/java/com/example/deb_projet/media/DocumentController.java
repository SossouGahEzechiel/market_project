package com.example.deb_projet.media;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.example.deb_projet.service.SaleService;
import com.example.deb_projet.service.UserService;
import com.lowagie.text.DocumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentController {
  
  @Autowired
  DocumentService documentService;

  
  @Autowired
  UserService userService;

  
  @Autowired
  SaleService saleService;

  @GetMapping("doc")
  public void docMaker(HttpServletResponse response) throws DocumentException, IOException{
    response.setContentType("application/pdf");

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
    String currentDateTime = dateFormat.format(new Date());

    String headerKey = "Content-Disposotion";
    String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
    response.setHeader(headerKey, headerValue);

    documentService.export(response, userService.get(2), saleService.get(3));
  }
}
