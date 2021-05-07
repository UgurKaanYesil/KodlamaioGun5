package kodlamaIoD5Hw.businnes.concretes;

import java.util.List;

import kodlamaIoD5Hw.businnes.abstracts.UserService;
import kodlamaIoD5Hw.core.EmailService;
import kodlamaIoD5Hw.dataAccess.abstracts.UserDao;
import kodlamaIoD5Hw.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public void add(User user) {
		
		userDao.add(user);	
		System.out.println("Log: " + user.geteMail());
		emailService.send(user.geteMail(), "Kayıt oldunuz.");
		
	}

	@Override
	public void add(String email) {
		
		User user =new User();
		user.seteMail(email);
		userDao.add(user);
		System.out.println("Log2: " + user.geteMail());
		emailService.send(email,"Kayıt oldunuz.");
		
	}

	@Override
	public void update(User user) {
		
		if(userValidate(user)) {
			
			userDao.update(user);
			
		}
		
	}

	@Override
	public void delete(int userId) {
		
		userDao.delete(userId);	
		
	}

	@Override
	public User get(String email) {
		
		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		
		for (User user : userDao.getAll()) {
			
			System.out.println(user.getId() +" "+ user.geteMail() +" "+ user.getFullName());
			
		}
		
		return userDao.getAll();
	}

	public boolean userValidate(User user) {
		
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2) {
			
			return true;
			
		}
		
		System.out.println("Adınız ve soyadınız minimum 2 karakter olmalı.");
		
		return false;
	}
	

}
