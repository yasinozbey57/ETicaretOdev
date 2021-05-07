package eTicaretOdev;

import eTicaretOdev.business.abstracts.UserService;
import eTicaretOdev.business.concretes.UserManager;
import eTicaretOdev.core.EDevletValidatorManagerAdapter;
import eTicaretOdev.dataAccess.concretes.GoogleUserDao;
import eTicaretOdev.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new GoogleUserDao(),
				new EDevletValidatorManagerAdapter());
		
		
		User user = new User(1,"Yasin","ÖZBEY","yasin_2313@hotmail.com","1231231");
		userService.register(user);

	}

}
