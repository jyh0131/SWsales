package swsales.handler.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.mvc.CommandHandler;

public class ProductInsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/product/productRegForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String uploadPath = req.getRealPath("productIMG");
		}
		return null;
	}

}
