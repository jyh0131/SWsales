package swsales.handler.main;

import java.sql.Connection;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class SearchPwHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			String empId = req.getParameter("empId");
			String empMail = req.getParameter("empMail");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();
				Employee emp = new Employee(empId);
				Employee employee = dao.selectEmployeeByMail(conn, emp);
				
				if(employee == null || !employee.getEmpMail().equals(empMail)) {
					req.setAttribute("error", 1);
					return "/WEB-INF/view/main/searchPwForm.jsp";
				}
								
				//mail 받을 주소
				String to_email = empMail;
				
                
                //임시비밀번호 생성기
                Random rnd = new Random();
    			StringBuffer buf = new StringBuffer();
    			for(int i=0;i<10;i++) {
    				 if(rnd.nextBoolean()){
    				        buf.append((char)((int)(rnd.nextInt(26))+97));
    				    }else{

    				        buf.append((rnd.nextInt(10)));
    				    }
    				}
    			String empPass = String.format("%s", buf);
    			String title = "[Smart 소프트웨어(관리자용)] 임시비밀번호 재발급 인증 메일입니다.";
    			String content = String.format("임시비밀번호는 %s 입니다. 해당 비밀번호로 로그인 해주세요.", empPass);
    			
    			//임시비밀번호 데이터베이스 업데이트
    			Employee updateEmp = new Employee();
    			updateEmp.setEmpId(empId);
    			updateEmp.setEmpMail(empMail);
    			updateEmp.setEmpPass(empPass);
    			dao.updateEmpPass(conn, updateEmp);
    			
    			Boolean flag = gmailSend(to_email, title, content);
				System.out.println(flag);
				req.setAttribute("flag", flag);
				res.sendRedirect(req.getContextPath()+"/main/login.do");
    			
				return null;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

	public static Boolean gmailSend(String to_email, String title, String content) {
		// mail 서버 설정
		String host = "smtp.gmail.com";
		String user = "airplant02342";
		String password = "hyun0927!@";
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
			message.setSubject(title);
			message.setText(content);
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
