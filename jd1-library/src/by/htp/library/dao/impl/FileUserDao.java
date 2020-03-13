package by.htp.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao{
	
	@Override
	public boolean authorization(String login, String password) throws DaoException {
		if (login == null || login.isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		try {
			FileReader fr = new FileReader("src\\resources\\users.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	if ((line.contains("login=" + login + ",")) 
            			&& (line.contains("password=" + password + ","))) {
            		return true;
            	}
                line = reader.readLine();
            }
			return false;
			
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean registration(User newUser) throws DaoException{
		if (newUser == null) {
			throw new RuntimeException("error");// stub
		}
		try {
			int id = findLastLine(new FileReader("src\\resources\\users.txt")) + 1;
			FileWriter writer = new FileWriter("src\\resources\\users.txt", true);
			writer.write("id=" + id + " ");
			writer.write(newUser.toString());
			writer.append('\n');
			writer.close();
			return true;
			
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean changeUserStatus(int idUser, String newStatus) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private int findLastLine(FileReader fr) throws DaoException {
		try {
			int result = 0;
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	result++;
                line = reader.readLine();
            }
			return result;
			
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

}
