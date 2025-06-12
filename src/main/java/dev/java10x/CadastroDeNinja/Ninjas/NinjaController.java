package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }
    //mostrar todos os ninjas(Read)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Ninja criado";
    }
    //Mostrar todos os ninjas por Id (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Ninjas por ID";
    }
    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterado ninja por id";
    }
    //Deletar um ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletado o ninja";
    }


}
