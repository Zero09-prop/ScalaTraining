import java.util.Properties
import javax.mail.{Message, Session, Transport}
import javax.mail.internet.{InternetAddress, MimeMessage}

/*
 * A Mailer config object that uses Props and auto configures for gmail
 * if detected.
 */
object SmtpMailer extends App {
  val properties = new Properties()
  properties.put("mail.smtp.host", "smtp.gmail.com")
  val session = Session.getDefaultInstance(properties)
  val message = new MimeMessage(session)

  message.setFrom(new InternetAddress("mixail-popov-2000@yandex.ru"))
  message.addRecipients(Message.RecipientType.TO, "unclemisha1@gmail.com")
  message.setSubject("Greetings!")
  message.setText("Hello! Friend its stream support")

  Transport.send(message)
}
