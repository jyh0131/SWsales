package swsales.handler.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swsales.mvc.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		session.invalidate();
		
		res.sendRedirect(req.getContextPath()+"/main/main.do"); //홈 이동
		return null;
	}

}
