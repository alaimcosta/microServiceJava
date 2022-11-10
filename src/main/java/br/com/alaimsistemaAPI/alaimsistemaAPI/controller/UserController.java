package br.com.alaimsistemaAPI.alaimsistemaAPI.controller;

import br.com.alaimsistemaAPI.alaimsistemaAPI.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMensagem(){
        return "Trabalhando com Spring boot ";
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return usuarios;
    }
    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
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
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf){
        for(UserDTO userFilter: usuarios){
            if(userFilter.getCpf().equals(cpf)){ // método equals realiza comparações
                return userFilter;
            }
        }
        return null;
    }

    @PostMapping("/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO){ //RequestBody -> para receber dados no corpo da requisição
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }




}
