package eTicaretOdev.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import eTicaretOdev.business.abstracts.UserService;
import eTicaretOdev.core.ValidatorService;
import eTicaretOdev.dataAccess.abstracts.UserDao;
import eTicaretOdev.entities.concretes.User;

public class UserManager implements UserService {

	private ValidatorService validatorService;
	private UserDao userDao;
	List<User> users;

	public UserManager(UserDao userDao, ValidatorService validatorService) {
		this.userDao = userDao;
		this.users = userDao.getAll();
		this.validatorService = validatorService;
	}
	
	@Override
	public boolean register(User user) {
		if(user.getFirstName().length() <=2 && user.getLastName().length() <=2) {
			System.out.println("�sim ve Soyisim en az 2 karakterden olu�mal�d�r.");
		return false;
		}
		if(Pattern.matches(".+@gmail.com", user.getEMail())) {
			System.out.println("E Mail adresi kullan�l�yor.");
			return false;
		}
		if(user.getPassword().length() <=6) {
			System.out.println("�ifre en az 6 karakterden olu�mal�d�r. ");
			return false;
		}
		this.userDao.add(user);
		this.validatorService.validateSystem("Kullan�c� Eklendi "+ user.getFirstName()+" "+user.getLastName());
		return true;
	}

	@Override
	public boolean login(String eMail, String password) {
		for(User item : userDao.getAll()) {
			if(eMail == item.getEMail() && password == item.getPassword()) {
				System.out.println("Say�n : "+item.getFirstName()+" "+"Ba�ar�yla giri� yapt�n�z.");
				return true;
			}

		}
		return false;
	}

	@Override
	public void logout(User user) {
		System.out.println("Bara��yla ��k�� yap�ld�.");
		
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}
	
}
