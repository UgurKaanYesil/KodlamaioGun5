package kodlamaIoD5Hw;

import kodlamaIoD5Hw.businnes.concretes.AuthManager;
import kodlamaIoD5Hw.businnes.concretes.UserManager;
import kodlamaIoD5Hw.core.GoogleEmailManagerAdapter;
import kodlamaIoD5Hw.dataAccess.concretes.InMemoryUserDao;
import kodlamaIoD5Hw.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User(4,"Engin","Demirog","engindemirog@amil.com","123456",true);
		
		User user2 = new User(4,"Zafer","Çalışkan","zafercaliskan@amil.com","146754",false);
		
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		GoogleEmailManagerAdapter googleMailManagerAdapter = new GoogleEmailManagerAdapter();
		
		AuthManager authManager =new AuthManager(new UserManager(inMemoryUserDao, googleMailManagerAdapter));
		
		authManager.register(user1);
		authManager.register(user2);
		
		UserManager userManager = new UserManager(inMemoryUserDao, googleMailManagerAdapter);
		userManager.getAll();

	}

}
