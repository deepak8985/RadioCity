package com.radiocity.daoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferUnderflowException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.radiocity.dao.UserDao;
import com.radiocity.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory seesion;

	@Override
	@Transactional
	public void saveUser(File file){
		try {
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		String st;
		int i=2;
		while((st=bufferedReader.readLine())!=null) {
			User user=new User();
			user.setName(st.substring(0,19));
			user.setUserId(i);
			i++;
			System.out.println(st.substring(0,19)+"---"+st.substring(19,st.length()));
			//seesion.getCurrentSession().save(user);
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
