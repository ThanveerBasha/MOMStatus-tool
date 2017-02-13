package comm.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import com.sendgrid.SendGrid;

public class Utility {
	 public static String sendGrid(Exception excObj, String strClassName, String  strMethodName) {
		 try {

             // String to[] = {"gandla.prabhakar@ge.com","swethasree.kommalapati@ge.com","poornima.dasararaju@ge.com"}; // Mail id you want to send;

             //InternetAddress[] recipientAddress = new InternetAddress[to.length];

//System.out.println("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");

//SendGrid sendgrid = new SendGrid("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");

             SendGrid sendgrid = new SendGrid("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");

SendGrid.Email welcomeMail = new SendGrid.Email();



//welcomeMail.addTo("ajay.akiti@ge.com");

//welcomeMail.addTo("Poornima.dasararaju@ge.com");

welcomeMail.addTo("KD00476219@techmahindra.com");

//welcomeMail.addToName("swethasree.kommalapati@ge.com");

//welcomeMail.addCc("Poornima.dasararaju@ge.com");

System.out.println("KD00476219@techmahindra.com");

welcomeMail.addToName("MOMStatus");

welcomeMail.setFrom("KD00476219@techmahindra.com");

welcomeMail.setSubject("Test_Daily_Tasks_Status_Email_Notification");

//welcomeMail.setText("SERVICE NAME:Dayahead Service"+"EXCEPITON OCCURED IN CLASS:"+strClassName+"METHOD NAME :"+ strMethodName + "EXCEPTION DETAILS :"+excObj.getStackTrace());

//welcomeMail.setText("SERVICE NAME:Dayahead Service"+"EXCEPITON OCCURED IN CLASS:"+strClassName+"METHOD NAME :"+ strMethodName + "EXCEPTION DETAILS :"+excObj.getStackTrace()  );

StringWriter errors = new StringWriter();

excObj.printStackTrace(new PrintWriter(errors));

String strPrintStrackTrace = errors.toString();







//welcomeMail.setText("\n \n EXCEPITON OCCURED IN CLASS: " +strClassName+" \n \n *****This is Auto-generated mail, please do not reply*****");

welcomeMail.setText("\n \n SERVICE NAME:NOAA Service \n \n EXCEPITON OCCURED IN CLASS: " +strClassName+" \n \n METHOD NAME :"+ strMethodName+" \n \n EXCEPTION DETAILS :" + strPrintStrackTrace);

//welcomeMail.setText(body+"\n \n EDI Application Link: " +applicationURL+" \n \n *****This is Auto-generated mail, please do not reply*****");

System.out.println("==========mail sent successfully=======");



SendGrid.Response response = sendgrid.send(welcomeMail);

System.out.println(response.getMessage());

}

catch (Exception ee) {

ee.printStackTrace();

}

return strMethodName;



//return null;

	 }

}
