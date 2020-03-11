package lpbd.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lpbd.model.User;
import lpbd.repository.UserRepository;
import lpbd.response.ObjectUser;
import lpbd.service.UserService;
import lpbd.service.UserValidator;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserValidator userValidator;
	
	//repository
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public ObjectUser saveUser(ObjectUser objectUser) throws Exception {
		try {
			User user = userValidator.valideUser(objectUser);
			user.setIdUser(objectUser.getId());
			user = userRepository.save(user);
			objectUser.setId(user.getIdUser());	
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return objectUser;
	}

	@Override
	public ObjectUser getUserByID(Integer id) throws Exception{
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new Exception("Usuário não existente");
		}
		return preencherUser(user.get());
		
	}

	@Override
	public ObjectUser preencherUser(User user) {
		ObjectUser objectUser = new ObjectUser();
		objectUser.setCpf(user.getCpf());
		objectUser.setDataNascimento(user.getDataNascimento());
		objectUser.setId(user.getIdUser());
		objectUser.setNome(user.getNome());
		objectUser.setSobrenome(user.getSobrenome());
		objectUser.setTelefone(user.getTelefone());
		return objectUser;
	}
	
}
