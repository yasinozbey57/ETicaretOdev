package eTicaretOdev.dataAccess.concretes;

import java.util.List;

import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class BaseUserDao implements UserDao {

	List<User> users;

	@Override
	public void add(User user) {
		System.out.println("Kullan�c� normal hesap ile eklendi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� normal hesab� ile g�ncellendi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� normal hesab� ile silindi."+ user.getFirstName()+" "+user.getLastName());
		users.add(user);
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
