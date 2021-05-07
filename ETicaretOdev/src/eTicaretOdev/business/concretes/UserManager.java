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
			System.out.println("Ýsim ve Soyisim en az 2 karakterden oluþmalýdýr.");
		return false;
		}
		if(Pattern.matches(".+@gmail.com", user.getEMail())) {
			System.out.println("E Mail adresi kullanýlýyor.");
			return false;
		}
		if(user.getPassword().length() <=6) {
			System.out.println("Þifre en az 6 karakterden oluþmalýdýr. ");
			return false;
		}
		this.userDao.add(user);
		this.validatorService.validateSystem("Kullanýcý Eklendi "+ user.getFirstName()+" "+user.getLastName());
		return true;
	}

	@Override
	public boolean login(String eMail, String password) {
		for(User item : userDao.getAll()) {
			if(eMail == item.getEMail() && password == item.getPassword()) {
				System.out.println("Sayýn : "+item.getFirstName()+" "+"Baþarýyla giriþ yaptýnýz.");
				return true;
			}

		}
		return false;
	}

	@Override
	public void logout(User user) {
		System.out.println("Baraþýyla çýkýþ yapýldý.");
		
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}
	
}
