package com.usagi.Controller.Action.ajax;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.util.MAIL.mailhub.SMTPAuthenticator;

public class Email_Pw_Auth_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String mails = email.substring((email.indexOf("@") + 1)).toLowerCase();

		System.out.println(email);
		String url = "";
		// 12자리 비밀번호

		// ID 찾기 이전에 이메일 인증 ==> 인증 후 ==> 아이디 나오는 화면
		// 인증화면은 따로 추가
		// 인증 후, ID나오는건 AJAX 처리
		if (mails.equals("gmail.com")) {

			HttpSession session = request.getSession();

			int user = Integer.parseInt((String) session.getAttribute("user")); // 기본 인증 페이지

			System.out.println(user);

			StringBuffer temp = auth_random();
			String AuthentificationKey = temp.toString();
			System.out.println(AuthentificationKey);
			try {

				String mail_from = "althsuwpfl@gmail.com";
				String mail_to = email;
				String title = "인증번호 발송 안내입니다.";

				mail_from = new String(mail_from.getBytes("UTF-8"), "UTF-8");
				mail_to = new String(mail_to.getBytes("UTF-8"), "UTF-8");

				Properties prop = new Properties();
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.port", "587");

				Authenticator auth = new SMTPAuthenticator();

				Session sess = Session.getDefaultInstance(prop, auth);

				MimeMessage msg = new MimeMessage(sess);

				msg.setFrom(new InternetAddress(mail_from));
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));
				msg.setSubject(title, "UTF-8");
				msg.setContent("인증번호 : " + temp, "text/html; charset=UTF-8"); // 인증번호
				msg.setHeader("Content-type", "text/html; charset=UTF-8");

				Transport.send(msg);

				HttpSession saveKey = request.getSession();
				saveKey.setAttribute("AuthenticationKey", AuthentificationKey);

				JSONObject obj = new JSONObject();
				obj.put("msg", "conf");
				response.setContentType("application/x-json, charset=utf-8");
				response.getWriter().print(obj);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		} else if (mails.equals("naver.com")) {
			HttpSession session = request.getSession();

			// 메일서버 설정
			String host = "smtp.naver.com";
			String user = "althsupfl@naver.com"; // 자신의 네이버 계정 (서버 이메일)
			String password = "magese0n@!"; // 자신의 네이버 계정 비밀번호
			//
			System.out.println(email);
			// 메일 받을 이메일 (유저 이메일)
			String to_email = email;

			// smtp 서버 정보 설정
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.starttls.enable ", "true ");
			props.put("mail.debug", "true");
			//
			StringBuffer temp = auth_random();
			String AuthentificationKey = temp.toString();
			System.out.println(AuthentificationKey);

			Session session2 = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			//

			// email 전송
			try {
				MimeMessage msg = new MimeMessage(session2);
				msg.setFrom(new InternetAddress(user, "KH Books", "utf-8"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

				// 메일 제목
				msg.setSubject("반갑습니다. HK BOOKS 인증 메일입니다.");
				// 메일 내용
				msg.setText("인증 번호는 :" + temp);
				// 전송
				Transport.send(msg);

				System.out.println("이메일이 전송 되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpSession saveKey = request.getSession();
			saveKey.setAttribute("AuthenticationKey", AuthentificationKey);

			// 비밀번호 바꿀 때 조건에 들어가는 ID
			// request.setAttribute("id", o);
			//

			JSONObject obj = new JSONObject();
			obj.put("msg", "conf");
			response.setContentType("application/x-json, charset=utf-8");
			response.getWriter().print(obj);

		}

	}

	public StringBuffer auth_random() {
		// 인증번호 생성
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) rnd.nextInt(26)) + 97);
				break;
			// A-Z
			case 1:
				temp.append((char) ((int) rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp.append((char) ((int) rnd.nextInt(26)) + 65);
				break;
			}
		}
		return temp;

	}

}
