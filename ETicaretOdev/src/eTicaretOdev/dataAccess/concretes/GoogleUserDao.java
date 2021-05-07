package eTicaretOdev.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class GoogleUserDao implements UserDao{
	List<User> users =new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Kullan�c� Google hesab� ile eklendi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� Google hesab� ile g�ncellendi."+ user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� Google hesab� ile silindi."+ user.getFirstName()+" "+user.getLastName());
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}
}
