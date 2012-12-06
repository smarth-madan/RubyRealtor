package org.springframework.social.showcase.email;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.social.showcase.mlsListing.model.Property;

/**
 *
 * @author doraemon
 */
public class GoogleMail {
    
	private GoogleMail(){
		
	}
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

        System.out.println("Inside SENDDDDD...............................");
        System.out.println("username = "+username+" password = "+password+" recipientEmail ="+recipientEmail);
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
    		
    		List<Property> propertyList = new ArrayList<Property>();
    		Property property = new Property();
    		property.setMLS_ID("1");
    		property.setCity("San Jose");
    		property.setStreet("148, E. William Street");
    		property.setState("CA");
    		property.setZipcode("95112");
    		propertyList.add(property);
    		
			//GoogleMail.Send("shaunakkhedkar", "TIGERrules17", "rakesh.ranjan@sjsu.edu", "shaunakkhedkar@gmail.com,madan.smarth@gmail.com", "Cmpe 295B Email setup from APP working: Properties for you from Awesome Realtors", htmlMessage.toString());
    		//GoogleMail.Send("shaunakkhedkar", "TIGERrules17", "shaunakkhedkar@gmail.com", "shweta.dhamapurkar@gmail.com,priyankbhawsar@gmail.com,siddharthsavant@gmail.com,vrphanse@gmail.com,adityakoparkar@gmail.com,sagaranilbhosale@gmail.com,tarun.pepira@gmail.com,nakul.natu@gmail.com,preeteshdixit@gmail.com,ruchamjoshi@gmail.com,js.vartak@gmail.com", "NEW ... Vacation Planning from my WEB-APP", getHtmlMessage());
    		//GoogleMail.Send("shaunakkhedkar", "TIGERrules17", "shaunakkhedkar@gmail.com", "", "Vacation Planning from my WEB-APP... YOYO ", htmlMessage+getHtmlMessage());
    		GoogleMail.Send("awesomerealtor007", "AwesomeRealtor17", "awesomerealtor007@gmail.com", "", "Awesome Realtors:Property Suggestions for you(TEMPLATE)","<html>"+getHtmlHead().toString()+getBody(propertyList).toString()+"</html>");
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
    
    public static StringBuffer getHtmlHead(){
		StringBuffer htmlContent = new StringBuffer();
		htmlContent.append("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /><meta property='og:title' content='*|MC:SUBJECT|*' /><title></title>");
		htmlContent.append("<style type='text/css'>	#outlook a{padding:0;} body{width:100% !important;} .ReadMsgBody{width:100%;} .ExternalClass{width:100%;}body{-webkit-text-size-adjust:none;} body{margin:0; padding:0;} img{border:0; height:auto; line-height:100%; outline:none; text-decoration:none;}");
		htmlContent.append("table td{border-collapse:collapse;}	#backgroundTable{height:100% !important; margin:0; padding:0; width:100% !important;} body, #backgroundTable{ background-color:#FAFAFA;	} #templateContainer{ border: 1px solid #DDDDDD;}");
		htmlContent.append("h1, .h1{color:#202020;display:block;font-family:Arial;font-size:34px;font-weight:bold;line-height:100%;margin-top:0;margin-right:0;margin-bottom:10px;margin-left:0; text-align:left;}");	
		htmlContent.append("h2, .h2{color:#202020;display:block; font-family:Arial; font-size:30px; font-weight:bold; line-height:100%;	margin-top:0;margin-right:0;margin-bottom:10px;	margin-left:0;text-align:left;}");
		htmlContent.append("h3, .h3{color:#202020;display:block;font-family:Arial; font-size:26px;font-weight:bold;line-height:100%;margin-top:0;margin-right:0;margin-bottom:10px;	margin-left:0; text-align:left;}");
		htmlContent.append("h4, .h4{color:#202020;display:block;font-family:Arial; font-size:22px; font-weight:bold; line-height:100%; margin-top:0;margin-right:0;margin-bottom:10px;margin-left:0; text-align:left;}");
		htmlContent.append("#templatePreheader{ background-color:#FAFAFA;}.preheaderContent div{color:#505050;font-family:Arial;font-size:10px;line-height:100%;text-align:left;}");
		htmlContent.append(".preheaderContent div a:link, .preheaderContent div a:visited, .preheaderContent div a .yshortcuts{color:#336699;font-weight:normal;text-decoration:underline;}");
		htmlContent.append("#templateHeader{background-color:#FFFFFF;border-bottom:0;} .headerContent{color:#202020;font-family:Arial;font-size:34px;font-weight:bold;line-height:100%; padding:0;text-align:center; vertical-align:middle;}");
		htmlContent.append(".headerContent a:link, .headerContent a:visited, /* Yahoo! Mail Override */ .headerContent a .yshortcuts /* Yahoo! Mail Override */{ color:#336699; font-weight:normal; text-decoration:underline;}");
		htmlContent.append("#headerImage{height:auto;max-width:600px;} #templateContainer, .bodyContent{background-color:#FFFFFF;}");
		htmlContent.append(".bodyContent div{color:#505050;font-family:Arial;font-size:14px;line-height:150%;text-align:left;}");
		htmlContent.append(".bodyContent div a:link, .bodyContent div a:visited,  .bodyContent div a .yshortcuts {color:#336699;font-weight:normal;text-decoration:underline;}");
		htmlContent.append(".bodyContent img{display:inline;height:auto;} #templateSidebar{background-color:#FFFFFF;}.sidebarContent div{ color:#505050; font-family:Arial; font-size:12px; line-height:150%; text-align:left;}");
		htmlContent.append(".sidebarContent div a:link, .sidebarContent div a:visited, .sidebarContent div a .yshortcuts {color:#336699;font-weight:normal;text-decoration:underline;}");
		htmlContent.append(".sidebarContent img{display:inline;height:auto;}.leftColumnContent{background-color:#FFFFFF;}.leftColumnContent div{ color:#505050; font-family:Arial; font-size:14px;line-height:150%;text-align:left;}");
		htmlContent.append(".leftColumnContent div a:link, .leftColumnContent div a:visited, .leftColumnContent div a .yshortcuts { color:#336699; font-weight:normal; text-decoration:underline;}");
		htmlContent.append(".leftColumnContent img{display:inline;height:auto;} .rightColumnContent{ background-color:#FFFFFF;}	.rightColumnContent div{color:#505050;font-family:Arial;font-size:14px;line-height:150%;text-align:left;}");
		htmlContent.append(".rightColumnContent div a:link, .rightColumnContent div a:visited,  .rightColumnContent div a .yshortcuts { color:#336699; font-weight:normal; text-decoration:underline;}");
		htmlContent.append(".rightColumnContent img{display:inline;height:auto;} #templateFooter{background-color:#FFFFFF; border-top:0;}.footerContent div{ color:#707070;	 font-family:Arial;font-size:12px;line-height:125%;text-align:left;}");
		htmlContent.append(".footerContent div a:link, .footerContent div a:visited,.footerContent div a .yshortcuts {color:#336699;font-weight:normal; text-decoration:underline;}");
		htmlContent.append(".footerContent img{display:inline;}	#social{background-color:#FAFAFA; border:0;}#social div{ text-align:center;}");
		htmlContent.append("#utility{background-color:#FFFFFF;border:0;}#utility div{ text-align:center;}#monkeyRewards img{max-width:190px;}</style></head>");
		return htmlContent;
	}
    
    /*/resources/images/slide-01.jpg*/
    
    public static StringBuffer getBody(List<Property> propertyList){
    	StringBuffer htmlContent = new StringBuffer();
    	htmlContent.append("<body leftmargin='0' marginwidth='0' topmargin='0' marginheight='0' offset='0'><center><table border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' id='backgroundTable'>");
    	htmlContent.append("<tr><td align='center' valign='top'><table border='0' cellpadding='10' cellspacing='0' width='600' id='templatePreheader'> <tr><td valign='top' class='preheaderContent'>");
    	htmlContent.append("<table border='0' cellpadding='10' cellspacing='0' width='100%'><tr><td valign='top'><div mc:edit='std_preheader_content'> Some Properties/Homes chosen exclusively for you by Awesome Realtors.");
    	htmlContent.append("</div></td><td valign='top' width='190'><div mc:edit='std_preheader_links'><i><b>AWESOME REALTORS</b></i>.");
    	htmlContent.append("</div></td></tr></table></td></tr></table><table border='0' cellpadding='0' cellspacing='0' width='600' id='templateContainer'><tr><td align='center' valign='top'>");
    	htmlContent.append("<table border='0' cellpadding='0' cellspacing='0' width='600' id='templateHeader'><tr><td class='headerContent'><img src='http://localhost:8080/spring-social-showcase/resources/images/slide-01.jpg' style='max-width:600px;' id='headerImage campaign-icon' mc:label='header_image' mc:edit='header_image' mc:allowdesigner mc:allowtext />");
    	htmlContent.append("</td></tr></table></td></tr><tr><td align='center' valign='top'><table border='0' cellpadding='0' cellspacing='0' width='600' id='templateBody'><tr><td valign='top' width='400'>");
    	htmlContent.append("<table border='0' cellpadding='0' cellspacing='0' width='400'><tr><td valign='top'><table border='0' cellpadding='0' cellspacing='0' width='400'>");
    	htmlContent.append("<tr><td valign='top' class='bodyContent'><table border='0' cellpadding='20' cellspacing='0' width='100%'><tr><td valign='top'><div mc:edit='std_content00'><h2 class='h2'>Looking for a new House?</h2>");
    	htmlContent.append("We at <strong>Awesome Realtors</strong> have specifically chosen a few Properties based on the criteria you have sent us while Signing up.There are many others that might suit your expectations, but <b><i>below are some of them that we recommend</i></b>");
    	htmlContent.append("<br /><br />"+buildHtmlEmailContent(propertyList)+"<br />");
    	htmlContent.append("</div></td></tr></table></td></tr></table></td></tr><tr><td valign='top'><table border='0' cellpadding='0' cellspacing='0' width='400'><tr><td valign='top' width='180' class='leftColumnContent'>");
    	htmlContent.append("<table border='0' cellpadding='20' cellspacing='0' width='100%'><tr mc:repeatable><td valign='top'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/placeholder_160.gif' style='max-width:160px; margin-bottom:10px;' mc:label='image' mc:edit='tiwc200_image01' />");
    	htmlContent.append("<div mc:edit='tiwc200_content01'><h4 class='h4'>Thinking of buying a home?</h4><i>-Has years of extensive experience in residential real estate<br/><br/>-Has an outstanding reputation with a record of excellence in negotiation and sales<br/><br/>-Is technologically savvy and understands the latest technological trends<br/><br/>-Is an expert in the complex and ever-changing process of buying/selling a home<br/></i>");
    	htmlContent.append("</div></td></tr></table></td><td valign='top' width='180' class='rightColumnContent'><table border='0' cellpadding='20' cellspacing='0' width='100%'><tr mc:repeatable>");
    	htmlContent.append("<td valign='top'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/placeholder_160.gif' style='max-width:160px; margin-bottom:10px;' mc:label='image' mc:edit='tiwc200_image02' />");
    	htmlContent.append("<div mc:edit='tiwc200_content02'><h4 class='h4'>Thinking of Selling a home ?</h4><i>-Top Notch marketing strategies with leading edge technologies<br/><br/>-Large network of services that will get your home maximum exposure<br/><br/>-Skilled and trained negotiator <br/><br/>-Contact me for a free, no pressure consultation and market analysis of your home</i>");
    	htmlContent.append("</div></td></tr></table></td></tr></table></td></tr></table></td><td valign='top' width='200' id='templateSidebar'><table border='0' cellpadding='0' cellspacing='0' width='200'>");
    	htmlContent.append("<tr><td valign='top' class='sidebarContent'><table border='0' cellpadding='0' cellspacing='0' width='100%'><tr><td valign='top' style='padding-top:10px; padding-right:20px; padding-left:20px;'><table border='0' cellpadding='0' cellspacing='4'>");
    	htmlContent.append("<tr mc:hideable><td align='left' valign='middle' width='16'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/sfs_icon_facebook.png' style='margin:0 !important;' /></td>");
    	htmlContent.append("<td align='left' valign='top'><div mc:edit='sbwi_link_one'><a href='*|FACEBOOK:PROFILEURL|*'>Friend on Facebook</a></div></td></tr><tr mc:hideable><td align='left' valign='middle' width='16'>");
    	htmlContent.append("<img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/sfs_icon_twitter.png' style='margin:0 !important;' /></td><td align='left' valign='top'><div mc:edit='sbwi_link_two'>");
    	htmlContent.append("<a href='*|TWITTER:PROFILEURL|*'>Follow on Twitter</a></div></td></tr><tr mc:hideable><td align='left' valign='middle' width='16'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/sfs_icon_forward.png' style='margin:0 !important;' />");
    	htmlContent.append("</td><td align='left' valign='top'><div mc:edit='sbwi_link_three'><a href='*|FORWARD|*'>Forward to a Friend</a></div></td></tr></table></td></tr></table> <table border='0' cellpadding='20' cellspacing='0' width='100%'>");
    	htmlContent.append("<tr mc:repeatable><td valign='top'><img src='http://localhost:8080/spring-social-showcase/resources/images//agent2.jpg' style='max-width:160px; margin-bottom:10px;' mc:edit='tiwc200_image00' />");
    	htmlContent.append("<div mc:edit='tiwc200_content00'><h4 class='h4'>About me:</h4><strong> Frances Navarro - <br />Fremont CA Real estate agent.<br /> Direct:   (720)648-6010 <br /> Office:   (408)477-5008 <br /> Cell:   (408)666-3236 <br /> Fax: (408)477-5008 <br /> awesomerealtor007@gmail.com <br/> <a href='#'>www.fnavaroo4homes.com</a>");
    	htmlContent.append("<div mc:edit='tiwc200_content00'></div></td></tr></table></td></tr></table></td></tr></table></td></tr><tr><td align='center' valign='top'>");
    	htmlContent.append("<table border='0' cellpadding='10' cellspacing='0' width='600' id='templateFooter'><tr><td valign='top' class='footerContent'><table border='0' cellpadding='10' cellspacing='0' width='100%'>");
    	htmlContent.append("<tr><td colspan='2' valign='middle' id='social'><div mc:edit='std_social'>&nbsp;<a href='*|TWITTER:PROFILEURL|*'>follow on Twitter</a> | <a href='*|FACEBOOK:PROFILEURL|*'>friend on Facebook</a> | <a href='*|FORWARD|*'>forward to a friend</a>&nbsp;");
    	htmlContent.append("</div></td></tr><tr><td valign='top' width='350'><div mc:edit='std_footer'><em>Copyright &copy; 2012 <br /> Smarth Madan and Shaunak Khedkar,<br /> <a href='http://www.sjsu.edu/computereng/'>SJSU CmpE Department</a>, All rights reserved.</em><br />");
    	htmlContent.append("<br /><strong>Our mailing address is:</strong><br />One Washington Square, San Jose CA-95112</div></td>");
    	htmlContent.append("<td valign='top' width='190' id='monkeyRewards'><div mc:edit='monkeyrewards'>REWARDS <br/> <I>Best Real Estate Agent, 2011</I></div></td></tr><tr>");
    	htmlContent.append("<td colspan='2' valign='middle' id='utility'><div mc:edit='std_utility'>&nbsp;<a href='*|UNSUB|*'>unsubscribe from this list</a> | <a href='*|UPDATE_PROFILE|*'>update subscription preferences</a>&nbsp;");
    	htmlContent.append("</div></td></tr></table></td></tr></table></td></tr></table><br /></td></tr></table></center></body>");
    	return htmlContent;
    }
    
    
    public static StringBuffer getBodyForAppointments(String message){
    	StringBuffer htmlContent = new StringBuffer();
    	htmlContent.append("<body leftmargin='0' marginwidth='0' topmargin='0' marginheight='0' offset='0'><center><table border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' id='backgroundTable'>");
    	htmlContent.append("<tr><td align='center' valign='top'><table border='0' cellpadding='10' cellspacing='0' width='600' id='templatePreheader'> <tr><td valign='top' class='preheaderContent'>");
    	htmlContent.append("<table border='0' cellpadding='10' cellspacing='0' width='100%'><tr><td valign='top'><div mc:edit='std_preheader_content'> Some Properties/Homes chosen exclusively for you by Awesome Realtors.");
    	htmlContent.append("</div></td><td valign='top' width='190'><div mc:edit='std_preheader_links'><i><b>AWESOME REALTORS</b></i>.");
    	htmlContent.append("</div></td></tr></table></td></tr></table><table border='0' cellpadding='0' cellspacing='0' width='600' id='templateContainer'><tr><td align='center' valign='top'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/placeholder_160.gif' style='max-width:160px; margin-bottom:10px;' mc:label='image' mc:edit='tiwc200_image01' />");
    	htmlContent.append("<table border='0' cellpadding='0' cellspacing='0' width='600' id='templateHeader'><tr><td class='headerContent'><img src='http://localhost:8080/spring-social-showcase/resources/images/slide-01.jpg' style='max-width:600px;' id='headerImage campaign-icon' mc:label='header_image' mc:edit='header_image' mc:allowdesigner mc:allowtext />");
    	htmlContent.append("</td></tr></table></td></tr><tr><td align='center' valign='top'><table border='0' cellpadding='0' cellspacing='0' width='600' id='templateBody'><tr><td valign='top' width='400'>");
    	htmlContent.append("<table border='0' cellpadding='0' cellspacing='0' width='400'><tr><td valign='top'><table border='0' cellpadding='0' cellspacing='0' width='400'>");
    	htmlContent.append("<tr><td valign='top' class='bodyContent'><table border='0' cellpadding='20' cellspacing='0' width='100%'><tr><td valign='top'><div mc:edit='std_content00'><h2 class='h2'>Looking for a new House?</h2>");
    	htmlContent.append("<B>Appointment details/Info update:</B>");
    	htmlContent.append("<br /><br /><b>MESSAGE: </b><br/><b><i>"+message+"</i></b><br />");
    	htmlContent.append("</div></td></tr></table></td></tr></table></td></tr><tr><td valign='top'><table border='0' cellpadding='0' cellspacing='0' width='400'><tr><td valign='top' width='180' class='leftColumnContent'>");
    	htmlContent.append("<table border='0' cellpadding='20' cellspacing='0' width='100%'><tr mc:repeatable><td valign='top'>");
    	htmlContent.append("<div mc:edit='tiwc200_content01'><h4 class='h4'>Thinking of buying a home?</h4><i>-Has years of extensive experience in residential real estate<br/><br/>-Has an outstanding reputation with a record of excellence in negotiation and sales<br/><br/>-Is technologically savvy and understands the latest technological trends<br/><br/>-Is an expert in the complex and ever-changing process of buying/selling a home<br/></i>");
    	htmlContent.append("</div></td></tr></table></td><td valign='top' width='180' class='rightColumnContent'><table border='0' cellpadding='20' cellspacing='0' width='100%'><tr mc:repeatable>");
    	htmlContent.append("<td valign='top'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/placeholder_160.gif' style='max-width:160px; margin-bottom:10px;' mc:label='image' mc:edit='tiwc200_image02' />");
    	htmlContent.append("<div mc:edit='tiwc200_content02'><h4 class='h4'>Thinking of Selling a home ?</h4><i>-Top Notch marketing strategies with leading edge technologies<br/><br/>-Large network of services that will get your home maximum exposure<br/><br/>-Skilled and trained negotiator <br/><br/>-Contact me for a free, no pressure consultation and market analysis of your home</i>");
    	htmlContent.append("</div></td></tr></table></td></tr></table></td></tr></table></td><td valign='top' width='200' id='templateSidebar'><table border='0' cellpadding='0' cellspacing='0' width='200'>");
    	htmlContent.append("<tr><td valign='top' class='sidebarContent'><table border='0' cellpadding='0' cellspacing='0' width='100%'><tr><td valign='top' style='padding-top:10px; padding-right:20px; padding-left:20px;'><table border='0' cellpadding='0' cellspacing='4'>");
    	htmlContent.append("<tr mc:hideable><td align='left' valign='middle' width='16'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/sfs_icon_facebook.png' style='margin:0 !important;' /></td>");
    	htmlContent.append("<td align='left' valign='top'><div mc:edit='sbwi_link_one'><a href='*|FACEBOOK:PROFILEURL|*'>Friend on Facebook</a></div></td></tr><tr mc:hideable><td align='left' valign='middle' width='16'>");
    	htmlContent.append("<img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/sfs_icon_twitter.png' style='margin:0 !important;' /></td><td align='left' valign='top'><div mc:edit='sbwi_link_two'>");
    	htmlContent.append("<a href='*|TWITTER:PROFILEURL|*'>Follow on Twitter</a></div></td></tr><tr mc:hideable><td align='left' valign='middle' width='16'><img src='http://gallery.mailchimp.com/653153ae841fd11de66ad181a/images/sfs_icon_forward.png' style='margin:0 !important;' />");
    	htmlContent.append("</td><td align='left' valign='top'><div mc:edit='sbwi_link_three'><a href='*|FORWARD|*'>Forward to a Friend</a></div></td></tr></table></td></tr></table> <table border='0' cellpadding='20' cellspacing='0' width='100%'>");
    	htmlContent.append("<tr mc:repeatable><td valign='top'><img src='http://localhost:8080/spring-social-showcase/resources/images//agent2.jpg' style='max-width:160px; margin-bottom:10px;' mc:edit='tiwc200_image00' />");
    	htmlContent.append("<div mc:edit='tiwc200_content00'><h4 class='h4'>About me:</h4><strong> Frances Navarro - <br />Fremont CA Real estate agent.<br /> Direct:   (720)648-6010 <br /> Office:   (408)477-5008 <br /> Cell:   (408)666-3236 <br /> Fax: (408)477-5008 <br /> awesomerealtor007@gmail.com <br/> <a href='#'>www.fnavaroo4homes.com</a>");
    	htmlContent.append("<div mc:edit='tiwc200_content00'></div></td></tr></table></td></tr></table></td></tr></table></td></tr><tr><td align='center' valign='top'>");
    	htmlContent.append("<table border='0' cellpadding='10' cellspacing='0' width='600' id='templateFooter'><tr><td valign='top' class='footerContent'><table border='0' cellpadding='10' cellspacing='0' width='100%'>");
    	htmlContent.append("<tr><td colspan='2' valign='middle' id='social'><div mc:edit='std_social'>&nbsp;<a href='*|TWITTER:PROFILEURL|*'>follow on Twitter</a> | <a href='*|FACEBOOK:PROFILEURL|*'>friend on Facebook</a> | <a href='*|FORWARD|*'>forward to a friend</a>&nbsp;");
    	htmlContent.append("</div></td></tr><tr><td valign='top' width='350'><div mc:edit='std_footer'><em>Copyright &copy; 2012 <br /> Smarth Madan and Shaunak Khedkar,<br /> <a href='http://www.sjsu.edu/computereng/'>SJSU CmpE Department</a>, All rights reserved.</em><br />");
    	htmlContent.append("<br /><strong>Our mailing address is:</strong><br />One Washington Square, San Jose CA-95112</div></td>");
    	htmlContent.append("<td valign='top' width='190' id='monkeyRewards'><div mc:edit='monkeyrewards'>REWARDS <br/> <I>Best Real Estate Agent, 2011</I></div></td></tr><tr>");
    	htmlContent.append("<td colspan='2' valign='middle' id='utility'><div mc:edit='std_utility'>&nbsp;<a href='*|UNSUB|*'>unsubscribe from this list</a> | <a href='*|UPDATE_PROFILE|*'>update subscription preferences</a>&nbsp;");
    	htmlContent.append("</div></td></tr></table></td></tr></table></td></tr></table><br /></td></tr></table></center></body>");
    	return htmlContent;
    }
    
    public static StringBuffer buildHtmlEmailContent(List<Property> propertyList){
		StringBuffer htmlContent = new StringBuffer();

		for(Property property: propertyList){
			htmlContent.append("<table border='0'><tr><td>");

			htmlContent.append("<table border='0'>");
			htmlContent.append("<tr><td><b>Property:</b></td><td></td></tr>");
			htmlContent.append("<tr style='background-color: #F0F0F0 ;'>");
			htmlContent.append("<td>MLS ID</td><td>");
			htmlContent.append(property.getMLS_ID());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color:#F8F8F8;'>");
			htmlContent.append("<td>Size</td><td>");
			htmlContent.append(property.getSize());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color: #F0F0F0 ;'>");
			htmlContent.append("<td>Address</td><td>");
			htmlContent.append(property.getStreet()+" ,"+property.getCity()+" '"+property.getState()+" ,"+property.getZipcode());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color:#F8F8F8;'>");
			htmlContent.append("<td>Price</td><td>");
			htmlContent.append(property.getPrice());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color: #F0F0F0 ;'>");
			htmlContent.append("<td>Type</td><td>");
			htmlContent.append(property.getType());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color:#F8F8F8;'>");
			htmlContent.append("<td>Bed/Bath</td><td>");
			htmlContent.append(property.getBed_bath());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color: #F0F0F0 ;'>");
			htmlContent.append("<td>Garage</td><td>");
			htmlContent.append(property.getGarage());
			htmlContent.append("</td></tr>");



			htmlContent.append("<tr style='background-color:#F8F8F8;'>");
			htmlContent.append("<td>Parking</td><td>");
			htmlContent.append(property.getParking());
			htmlContent.append("</td></tr></table>");

			htmlContent.append("</td><td valign='top'><table><tr><td><i><font style='valign:top'><b>Pic: </b></font></i><br /></td></tr>");
			htmlContent.append("<tr><td><img height='125' width='150' src='http://localhost:8080/spring-social-showcase/resources/images//property1.gif' alt='No Image Available' /></td></tr></table></td></tr></table>");
		}
		return htmlContent;

	}
  

}
