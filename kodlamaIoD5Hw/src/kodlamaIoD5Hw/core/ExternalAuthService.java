package kodlamaIoD5Hw.core;

import kodlamaIoD5Hw.entities.concretes.LoginDto;

public interface ExternalAuthService {
	
	void register(String email);
	boolean userExists(String email);
	void login(LoginDto dto);
}
