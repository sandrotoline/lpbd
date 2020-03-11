package lpbd.service;

import lpbd.model.User;
import lpbd.response.ObjectUser;

public interface UserService {
	public ObjectUser saveUser(ObjectUser objectUser) throws Exception;
	
	public ObjectUser getUserByID(Integer id) throws Exception;
	
	public ObjectUser preencherUser(User user);
}
