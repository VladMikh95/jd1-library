package by.htp.library.start;

import by.htp.library.bean.User;
import by.htp.library.controller.Controller;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.impl.FileUserDao;

public class Main {

	public static void main(String[] args) throws DaoException {
		/*Controller controller = new Controller();
		
		String request, response;
		
		request = "login=aaa password=bbb name=Ivan";

		response = controller.action(request);
		
		System.out.println(response);*/
		
		User user = new User("aaa", "bbb", "ccc", "ddd");
		
		FileUserDao fl = new FileUserDao();
		fl.registration(user);
		System.out.println(fl.authorization("aaa", "bbb"));
		
		
	}

}
