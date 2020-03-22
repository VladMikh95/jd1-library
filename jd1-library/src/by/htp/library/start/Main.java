package by.htp.library.start;

import by.htp.library.bean.*;
import by.htp.library.controller.Controller;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.impl.FileAdminDao;
import by.htp.library.dao.impl.FileUserDao;

public class Main {

	public static void main(String[] args) throws DaoException {
		Controller controller = new Controller();
		
		/*String request, response;
		
		request = "login=aaa password=bbb name=Ivan";

		response = controller.action(request);
		
		System.out.println(response);*/
		
		FileUserDao fl = new FileUserDao();
		
		User user = new User("aab", "bbb", "ccc", "ddd");
	
		fl.registration(user);
		System.out.println(fl.authorization("aaa", "bbb"));
		System.out.println(fl.changeUserStatus(2, "blocked"));
		
		
		FileAdminDao fa = new FileAdminDao();
		Book book = new Book("Бейтс", "Изучаем Java", "paper", 50);
		fa.add(book);
		System.out.println(fa.edit(2, new Book("Эккель", "Философия Java", "paper, dig", 40)));
	}

}
