package kodlamaIoD5Hw.businnes.abstracts;

import kodlamaIoD5Hw.entities.concretes.LoginDto;
import kodlamaIoD5Hw.entities.concretes.User;

public interface AuthService {
	void register(User user);
	void verify(User user, String token);
	boolean userExists(String email);
	void login(LoginDto dto);
}
