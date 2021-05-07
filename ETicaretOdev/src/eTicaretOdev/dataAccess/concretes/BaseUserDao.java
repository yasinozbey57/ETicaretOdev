package eTicaretOdev.dataAccess.concretes;

import java.util.List;

import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class BaseUserDao implements UserDao {

	List<User> users;

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý normal hesap ile eklendi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý normal hesabý ile güncellendi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý normal hesabý ile silindi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
