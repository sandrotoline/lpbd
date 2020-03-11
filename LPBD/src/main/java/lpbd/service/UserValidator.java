package lpbd.service;

import lpbd.model.User;
import lpbd.response.ObjectUser;

public interface UserValidator {
	public User valideUser(ObjectUser objectUser) throws Exception;
}
