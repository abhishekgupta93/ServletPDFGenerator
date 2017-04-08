// Import required java libraries
import java.io.*;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloForm extends HttpServlet {
 
   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // Set response content type
	   String name= request.getParameter("first_name");
	   String last_name = request.getParameter("last_name");
	   String date = request.getParameter("date_picked") ;
	   String address= request.getParameter("address");
	   String description = request.getParameter("description");
	   
		date = date.replace("-", "_");
		String filename = "Report_"+date+".pdf";
     
      CreatePDF cp = new CreatePDF();
      PrintWriter out = response.getWriter();
      response.setContentType("APPLICATION/OCTET-STREAM"); 
	  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 

      String title = "Using GET Method to Read Form Data";
		
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
			
			cp.create(date,name,last_name,address,description);
			
     try {
    	 System.out.println("sleeping started");
    	 out.println("Preparing file");
		Thread.sleep(5000);
		System.out.println("sleeping finished");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
      
      File dir = new File("C://Eclipse//Luna work//ServletPDFGenerator//Reports");
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept (File dir, String name) { 
            return name.startsWith("b");
         } 
      }; 
      String[] children = dir.list(filter);
      if (children == null) {
         System.out.println("Either dir does not exist or is not a directory"); 
      } else { 
         for (int i=0; i< children.length; i++) {
            String filename1 = children[i];
            System.out.println(filename1);
         }
         java.io.FileInputStream fileInputStream = new java.io.FileInputStream("C://Eclipse//Luna work//ServletPDFGenerator//Reports//Report_"+date+".pdf");
         int i; 
		  while ((i=fileInputStream.read()) != -1) {
		    out.write(i); 
		  } 
		  fileInputStream.close(); 
		  out.close(); 
      } 
   }
	
   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doGet(request, response);
   }
}