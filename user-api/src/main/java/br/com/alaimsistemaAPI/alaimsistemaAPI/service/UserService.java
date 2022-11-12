package br.com.alaimsistemaAPI.alaimsistemaAPI.service;

import br.com.alaimsistemaAPI.alaimsistemaAPI.dto.UserDTO;
import br.com.alaimsistemaAPI.alaimsistemaAPI.model.User;
import br.com.alaimsistemaAPI.alaimsistemaAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// será criado uma instancia da classe na inicialização da aplicação
@Service
public class UserService {

    @Autowired //Fará a injeção de dependencias
    private UserRepository userRepository;

    public List<UserDTO> getAll() { //
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    //metodo para buscar um usuário pelo Id
    public UserDTO findById(long userId) {
        Optional<User> usuarios = userRepository.findById(userId);
        if(usuarios.isPresent()){ //se existe um valor presente na instância Optional
            return UserDTO.convert(usuarios.get());
        }
        return null;
    }

    //salvar o usuário no BD
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    //Excluir usuário do banco de dados
    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    // busca um usuário pelo cpf
    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if(user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    //aqui busca pelo nome do usuário, porém a diferença é que a busca não será exata, podendo passar parte do nome
    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }


}
