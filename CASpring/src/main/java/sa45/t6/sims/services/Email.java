package sa45.t6.sims.services;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Email implements EmailService {
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.simple.services.EmailService#sendSimpleMail()
	 */
	@Override
	public void sendSimpleMail(String id,String ordernum) throws Exception {

		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        // setting for mail authentication
        senderImpl.setHost("smtp.gmail.com");
        senderImpl.setPort(587);
        senderImpl.setUsername("woihjzfr@gmail.com"); 
        senderImpl.setPassword("Aa123456abc"); 
        
        Properties prop = new Properties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        
        // message details
       SimpleMailMessage mailMessage = new SimpleMailMessage();
        
      mailMessage.setFrom("woihjzfr@gmail.com");
        mailMessage.setTo("sunhappyszc@163.com");
       mailMessage.setSubject("Product Order Request ");
       mailMessage.setText("Dear supplier, we would like to place an order for Part Number " + id + " of quantity " + ordernum + ". Thank You.");
       
       // send message
        senderImpl.send(mailMessage);

             
        // send html message
        MimeMessage message = null;
        try {
        	message=senderImpl.createMimeMessage();       
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("woihjzfr@gmail.com");
            helper.setTo("sunhappyszc@163.com");
            helper.setSubject("message in html style");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>big tittle-h1</h1>")
                    .append("<p style='color:#F00'>red font</p>")
                    .append("<p style='text-align:right'>on the right</p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        senderImpl.send(message);
        
	}

}
