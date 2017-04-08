


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 


import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

import javafx.scene.text.Text;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class CreatePDF {

	public static void create(String date,String name,String last_name,String address,String description) throws MalformedURLException, IOException
	   {
	      Document document = new Document();
	  	int i =0;
	      String startDateString = date;
	      try
	      {
	    	  
             
	    	  Font BLACKFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C://Eclipse//Luna work//ServletPDFGenerator//Reports//Report_"+startDateString+".pdf"));
	         document.open();
	         document.addTitle("Pickup Report for "+startDateString);
	        
	         
	         
	         Image image1 = Image.getInstance("C://Eclipse//Luna work//ServletPDFGenerator//Logos//ServletPDFGenerator.png");
	         //Fixed Positioning
	         image1.setAbsolutePosition(20f, 750f);
	         //Scale to new height and new width of image
	       //  image1.scaleAbsolute(177, 52);
	         //Add to document
	         document.add(image1);
	         
	         
	         Image image2 = Image.getInstance("C://Eclipse//Luna work//ServletPDFGenerator//Logos//RedSquare.png");
	         //Fixed Positioning
	         image2.setAbsolutePosition(400f, 720f);
	         //Scale to new height and new width of image
	      //  image2.scaleAbsolute(177, 52);
	         //Add to document
	         document.add(image2);
	         Paragraph paragraphOne = new Paragraph("  ", BLACKFont);
	        document.add(paragraphOne);
	        
	        Paragraph paragraphOne1 = new Paragraph("  ", BLACKFont);
	        document.add(paragraphOne1);
	        Paragraph paragraphOne2 = new Paragraph("  ", BLACKFont);
	        document.add(paragraphOne2);
	        Paragraph paragraphOne3 = new Paragraph("  ", BLACKFont);
	        document.add(paragraphOne3);
	        Paragraph paragraphOne4 = new Paragraph("  ", BLACKFont);
	        document.add(paragraphOne4);
	        
	        Paragraph paragraphOne5 = new Paragraph("PDF REPORT ", BLACKFont);
	        document.add(paragraphOne5);
	        Paragraph paragraphOne6 = new Paragraph("Name: "+name+" "+last_name, BLACKFont);
	        document.add(paragraphOne6);
	        Paragraph paragraphOne7 = new Paragraph("Address: "+address, BLACKFont);
	        document.add(paragraphOne7);
	        Paragraph paragraphOne8 = new Paragraph("Description: "+description, BLACKFont);
	        document.add(paragraphOne8);
	        Paragraph paragraphOne9 = new Paragraph("TimeStamp: "+date, BLACKFont);
	        document.add(paragraphOne9);
	      
	         document.close();
	         writer.close();
	         System.out.println("Done");
	        
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	   }
}

