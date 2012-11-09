package org.springframework.social.showcase.email;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author doraemon
 */
public class GoogleMail {
    

    /**
     * Send email using GMail SMTP server.
     *
     * @param username GMail username
     * @param password GMail password
     * @param recipientEmail TO recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    public static void Send(final String username, final String password, String recipientEmail, String title, String message) throws AddressException, MessagingException {
        GoogleMail.Send(username, password, recipientEmail, "", title, message);
    }

    /**
     * Send email using GMail SMTP server.
     *
     * @param username GMail username
     * @param password GMail password
     * @param recipientEmail TO recipient
     * @param ccEmail CC recipient. Can be empty if there is no CC recipient
     * @param title title of the message
     * @param message message to be sent
     * @throws AddressException if the email address parse failed
     * @throws MessagingException if the connection is dead or not in the connected state or if the message is not a MimeMessage
     */
    public static void Send(final String username, final String password, String recipientEmail, String ccEmail, String title, String message) throws AddressException, MessagingException {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set 
        to true (the default), causes the transport to wait for the response to the QUIT command.

        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                http://forum.java.sun.com/thread.jspa?threadID=5205249
                smtpsend.java - demo program from javamail
        */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

        if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }

        msg.setSubject(title);
        //msg.setText(message, "utf-8");
        msg.setContent(message, "text/html");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());      
        t.close();
    }
    
    public static void main(String []args){
    	try {
    		StringBuffer htmlMessage = new StringBuffer("<html><head></head><body> <h2>Property Information for you</h2>");
    		htmlMessage.append("<table border='0'><tr style='background-color: #0099CC;'><td>Property 1 :</td><td></td></tr>");
    		htmlMessage.append("<tr style='background-color: #D0D0D0 ;'><td>MLS ID</td><td> 12345 </td></tr>");
    		htmlMessage.append("<tr style='background-color:#E0E0E0;' ><td>Address</td><td> 148, E.William Street, San Jose, CA-95112 </td></tr>");
    		htmlMessage.append("<tr style='background-color:#D0D0D0;' ><td>Price</td><td> $250,000 </td></tr>");
    		htmlMessage.append("</table></body></html>");
    		htmlMessage.append("<br /> Hello Professor our email functionality works. This message has been sent from the Application.</body></html>");
			//GoogleMail.Send("shaunakkhedkar", "TIGERrules17", "rakesh.ranjan@sjsu.edu", "shaunakkhedkar@gmail.com,madan.smarth@gmail.com", "Cmpe 295B Email setup from APP working: Properties for you from Awesome Realtors", htmlMessage.toString());
    		//GoogleMail.Send("shaunakkhedkar", "TIGERrules17", "shaunakkhedkar@gmail.com", "shweta.dhamapurkar@gmail.com,priyankbhawsar@gmail.com,siddharthsavant@gmail.com,vrphanse@gmail.com,adityakoparkar@gmail.com,sagaranilbhosale@gmail.com,tarun.pepira@gmail.com,nakul.natu@gmail.com,preeteshdixit@gmail.com,ruchamjoshi@gmail.com,js.vartak@gmail.com", "NEW ... Vacation Planning from my WEB-APP", getHtmlMessage());
    		GoogleMail.Send("shaunakkhedkar", "TIGERrules17", "shaunakkhedkar@gmail.com", "", "Vacation Planning from my WEB-APP... YOYO ", htmlMessage+getHtmlMessage());
			System.out.println("Message sent.");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
    
    private static String getHtmlMessage(){
    	StringBuffer htmlMessage = new StringBuffer("<html><head></head><body> <h2>To all you nullas ..... Email from my web Application....</h2>");
		htmlMessage.append("<table border='0'><tr style='background-color: #0099CC;'><td>PLaces to go:</td><td></td></tr>");
		htmlMessage.append("<tr style='background-color: #D0D0D0 ;'><td>Miami</td><td> <a href='http://www.miamiandbeaches.com/explore-miami/beaches'> Miami Baby </a></td></tr>");
		htmlMessage.append("<tr style='background-color:#E0E0E0;' ><td>Death Valley</td><td> <a href='http://www.deathvalley.com/dv/index.php?option=com_content&view=frontpage&Itemid=47'> Haaloween part at death Valley </a> </td></tr>");
		htmlMessage.append("<tr style='background-color:#D0D0D0;' ><td>SO CAL</td><td>  <a href='http://www.tripadvisor.com/Tourism-g32780-Newport_Beach_California-Vacations.html'> LA /NEWPORT @ PHANSES </a> </td></tr>");
		htmlMessage.append("</table></body></html>");
		htmlMessage.append("<br /> I am soooo cooooooollly GEEKY. I like teasing <b>grils, Audya and Phanse</b> and make them cry.</body></html>");
		
		return htmlMessage.toString();
    }
}
