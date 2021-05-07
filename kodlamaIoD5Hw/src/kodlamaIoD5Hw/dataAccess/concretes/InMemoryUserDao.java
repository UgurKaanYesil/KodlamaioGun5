package kodlamaIoD5Hw.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoD5Hw.dataAccess.abstracts.UserDao;
import kodlamaIoD5Hw.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	private List<User> users = new ArrayList<User>();
	
	
	
	public InMemoryUserDao() {
		super();
		User user1 = new User(1,"Uğur Kaan","Yeşil","ugurkan@gmail.com","123456",true);
		User user2 = new User(1,"Asuman","Yeşil","asumanyesil@gmail.com","987654",true);
		User user3 = new User(1,"Hakkı","Yeşil","hakkiyesil@gmail.com","123456",true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream()
				.filter(u->u.getId()==user.getId())
				.findFirst()
				.orElse(null);
		
		userToUpdate.seteMail(user.geteMail());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
		
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u->u.getId()==userId)
				.findFirst()
				.orElse(null);
		
		users.remove(userToDelete);
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.geteMail() == email)
				.findFirst()
				.orElse(null);
		return user;
	}

}
