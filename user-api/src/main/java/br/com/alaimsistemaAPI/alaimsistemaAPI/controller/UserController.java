package br.com.alaimsistemaAPI.alaimsistemaAPI.controller;

import br.com.alaimsistemaAPI.alaimsistemaAPI.dto.UserDTO;
import br.com.alaimsistemaAPI.alaimsistemaAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers(){
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) { //RequestBody -> para receber dados no corpo da requisição
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    UserDTO delete(@PathVariable Long id){
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(
            @RequestParam(name="nome", required = true) //RequestParam --> quando queremos passar parametros na URL para rota
            String nome) {
        return userService.queryByName(nome);
    }

/*    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("João");
        userDTO.setCpf("122.569.548-58");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("joaogomes@gmail.com");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("589.569.548-58");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luizgomes@gmail.com");
        userDTO2.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Mônica");
        userDTO3.setCpf("878.569.548-58");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("monica@gmail.com");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }*/


}
