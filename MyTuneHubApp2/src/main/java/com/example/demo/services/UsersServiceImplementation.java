package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{
	@Autowired
	UsersRepository urepo;
	@Override
	public String addUser(Users user) {
		// TODO Auto-generated method stub
		urepo.save(user);
		return "user is created and saved";
	}
	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		if(urepo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		Users user=urepo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false ;
			}
	}
	@Override
	public String getRole(String email) {
		return urepo.findByEmail(email).getRole();
	}
	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		
		return urepo.findByEmail(email);
	}
	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		urepo.save(user);
	}

}
