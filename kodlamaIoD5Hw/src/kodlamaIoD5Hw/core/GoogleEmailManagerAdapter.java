package kodlamaIoD5Hw.core;

import kodlamaIoD5Hw.googleEmail.GoogleEmailManager;

public class GoogleEmailManagerAdapter implements EmailService{
	
private GoogleEmailManager googleMailManager;
	
	public GoogleEmailManagerAdapter() {
		googleMailManager = new GoogleEmailManager();
	}
	
	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);
		
	}

}
