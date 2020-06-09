package com.usagi.util.MAIL.naver;

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class naver {
	public naver(HttpServletRequest request, HttpServletResponse response,String url) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int user_I = Integer.parseInt((String) session.getAttribute("user")); // 기본 인증 페이지

		System.out.println(user_I);
		
		// 메일서버 설정
		String host = "smtp.naver.com";
		String user = "althsupfl@naver.com"; // 자신의 네이버 계정 (서버 이메일)
		String password = "magese0n@!"; // 자신의 네이버 계정 비밀번호
		//
		String email = (String) session.getAttribute("email");
		if (email == null) {
			email = (String) request.getParameter("email");
			request.setAttribute("email", email);
		}
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
        props.put("mail.smtp.starttls.enable ","true ");
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

		RequestDispatcher rd = request.getRequestDispatcher(url);
rd.forward(request, response);
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