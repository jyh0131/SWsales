package swsales.mvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ControllerUsingURI extends HttpServlet{
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		//Map 안에 Command와 Class가 담기게 처리함
		String configFile = getInitParameter("configFile"); //properties 파일 위치 가져오기
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile); //RealPath 절대주소 가져오기
		try(FileReader fis =  new FileReader(configFilePath)){ //properties 파일을 열어서 읽음
			prop.load(fis);
		}catch(Exception e){
			throw new ServletException(e);
		}

		Iterator keyIter =  prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next(); // /simple.do
			String handlerClassName = prop.getProperty(command); //com.yi.handler.SimpleHandler
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);  
				CommandHandler handlerInstance = 
						(CommandHandler) handlerClass.newInstance();  // 단순한 String을 클래스화 해서 new 한것
				commandHandlerMap.put(command, handlerInstance);
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI(); // /MVCProject/simple.do
		if(command.indexOf(request.getContextPath()) == 0) {
			// /simple.do
			command = command.substring(request.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) { //없는 command를 넣으면 null이 생성
			handler = new NullHandler();
		}
		
		String viewPage = null;
		
		try {
			viewPage = handler.process(request, response); // /simpleForm.jsp
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		if(viewPage != null) {
			RequestDispatcher dispather = request.getRequestDispatcher(viewPage);
			dispather.forward(request, response);
		}
	}
}

