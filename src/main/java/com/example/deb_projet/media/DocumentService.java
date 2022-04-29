package com.example.deb_projet.media;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import com.example.deb_projet.models.ProduitSale;
import com.example.deb_projet.models.Sale;
import com.example.deb_projet.models.User;
import com.example.deb_projet.service.ProduitSaleService;
import com.example.deb_projet.service.SaleService;
import com.example.deb_projet.service.UserService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

  @Autowired
  ProduitSaleService produitSaleService;

  public void export(HttpServletResponse response, User user, Sale sale) throws DocumentException, IOException{
    
    Document document = new Document(PageSize.A4);
    PdfWriter.getInstance(document, response.getOutputStream());
    
    String facture_header = "Facturé à \n"+user.getNom()+" "+user.getPrenom()+"\n Date de facturation: "+sale.getSaleDate();

    document.open();

    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    titleFont.setStyle(FontFactory.TIMES_ITALIC);
    titleFont.setSize(18);

    Paragraph paragraph = new Paragraph("Facture",titleFont);
    paragraph.setAlignment(Paragraph.ALIGN_CENTER);

    titleFont.setSize(16);
    Paragraph paragraph2 = new Paragraph(facture_header,titleFont);
    paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

    // Paragraph paragraph3 = new Paragraph("Un petit test d'affichage",titleFont);
    // paragraph3.setAlignment(Paragraph.ALIGN_RIGHT);

    List<ProduitSale> produitSales = produitSaleService.bySales(sale);

    Table table = new Table(4);
    table.addCell("Quantite");
    table.addCell("Libellé du produit");
    table.addCell("Prix unitaire");
    table.addCell("Montant total");

    produitSales.forEach( produitSale -> {
      table.addCell(""+produitSale.getQte_produit());
      table.addCell(produitSale.getProduit().getLib());
      table.addCell(""+produitSale.getProduit().getPrix());
      table.addCell(""+produitSale.getSale().getTotal_amount());
    });

    document.add(paragraph);
    document.add(paragraph2);
    // document.add(paragraph3);
    document.add(table);
    document.close();

  }
}
