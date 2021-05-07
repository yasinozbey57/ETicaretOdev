package eTicaretOdev.business.abstracts;

import java.util.List;
import eTicaretOdev.entities.concretes.User;

public interface UserService {
	boolean register(User user);
	boolean login(String eMail, String password);
	void logout(User user);
	List<User> getAll();
	//deneme1
}
