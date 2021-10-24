package PDF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Calculation.Calc;


public class CreatePDF {
	
	public String filepath;
	public String file1;
	public String CellGet;

	    public void Create(String numberpdf) throws IOException {
            Document document = new Document(); 
			try {
				File file = new File(CreatePDF.class.getProtectionDomain().getCodeSource().getLocation().toURI());
				file1 = new File(file.getParent()).getParent();
				filepath = file1 + "/Check.pdf";
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			}
			try {	
				PdfWriter.getInstance(document, new FileOutputStream(filepath));
			} catch (FileNotFoundException | DocumentException e) {
				e.printStackTrace();
			}
						
			document.open(); 
			
			BaseFont times = null;
			try {
				times = BaseFont.createFont(file1 + "/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
			} catch (DocumentException | IOException e) {
				e.printStackTrace();
			}
			
			String string_pdf = "Результат выполнения работы приложения";
			Paragraph paragraph = new Paragraph();
		    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
		    
		    String string_pdf2 = "С заказом можно ознакомиться в таблице ниже:";
		    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
		    
		     
		    try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
		    
		  
			 paragraph.clear();
			 String string_pdf3 = " ";
			 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
			 
			 try {
					document.add(paragraph);
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}
		    
		    
			 
			 paragraph.clear();
			 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
			 
			 try {
					document.add(paragraph);
				} catch (DocumentException e1) {
					e1.printStackTrace();
				}
	    
	 
			
			 PdfPTable table = new PdfPTable(3); 
			 addColumns(table);
			 try {
				document.add(table);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		    
		    document.close(); 
	    }
	    

	public void addColumns(PdfPTable table) {
		BaseFont times = null;
		try {
			times = BaseFont.createFont(file1 + "/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
			
		String cell1 = "";
		String cell2 = "Вид";
		String cell3 = "Цена (руб)";
		String cell4 = "Каркас";
		String cell5 = Calc.StekloGet; 
		String cell6 = Calc.StekloGetPrice;
		String cell7 = "Обивка";
		String cell8 = Calc.MaterialGet;
		String cell9 = Calc.MatsGetPrice;
		String cell10 = "Наполнитель";
		String cell11 = Calc.TsvetGet;
		String cell12 = Calc.TsvetaGetPrice;
		String cell13 = "Стул";
		String cell14 = Calc.StvorGet;
		String cell15 = Calc.BGetPrice;
		String cell16 = "Колличество стульев";
		String cell17 = Calc.AGet;
		String cell18 = "";
		String cell19 = "Срочный заказ?";
		String cell20 = Calc.check1Get;
		String cell21 = "";
		String cell22 = "";
		String cell23 = "ИТОГО:";
		String cell24 = Calc.Summa;
		
		CellGet = cell4;
		
		table.addCell(new Phrase(cell1, new Font(times,14)));	
		table.addCell(new Phrase(cell2, new Font(times,14)));	
		table.addCell(new Phrase(cell3, new Font(times,14)));	
		table.addCell(new Phrase(cell4, new Font(times,14)));	
		table.addCell(new Phrase(cell5, new Font(times,14)));	
		table.addCell(new Phrase(cell6, new Font(times,14)));	
		table.addCell(new Phrase(cell7, new Font(times,14)));	
		table.addCell(new Phrase(cell8, new Font(times,14)));	
		table.addCell(new Phrase(cell9, new Font(times,14)));	
		table.addCell(new Phrase(cell10, new Font(times,14)));	
		table.addCell(new Phrase(cell11, new Font(times,14)));	
		table.addCell(new Phrase(cell12, new Font(times,14)));	
		table.addCell(new Phrase(cell13, new Font(times,14)));	
		table.addCell(new Phrase(cell14, new Font(times,14)));	
		table.addCell(new Phrase(cell15, new Font(times,14)));	
		table.addCell(new Phrase(cell16, new Font(times,14)));			
		table.addCell(new Phrase(cell17, new Font(times,14)));	
		table.addCell(new Phrase(cell18, new Font(times,14)));	
		table.addCell(new Phrase(cell19, new Font(times,14)));			
		table.addCell(new Phrase(cell20, new Font(times,14)));	
		table.addCell(new Phrase(cell21, new Font(times,14)));	
		table.addCell(new Phrase(cell22, new Font(times,14)));	
		table.addCell(new Phrase(cell23, new Font(times,14)));		
		table.addCell(new Phrase(cell24, new Font(times,14)));	
		    
			
		    
		}
	}

