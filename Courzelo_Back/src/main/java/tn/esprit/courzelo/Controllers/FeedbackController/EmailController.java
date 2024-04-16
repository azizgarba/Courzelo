package tn.esprit.courzelo.Controllers.FeedbackController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.courzelo.entities.FeedBackEntities.EmailRequest;

@RestController

public class EmailController {
    private final JavaMailSender mailSender;
    @Autowired
    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("mohamedaziz.guerbouj@esprit.tn");
        helper.setTo(emailRequest.getRecipient());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getMessage(),true);

        mailSender.send(mimeMessage);
    }
}
