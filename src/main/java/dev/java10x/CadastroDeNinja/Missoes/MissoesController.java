package dev.java10x.CadastroDeNinja.Missoes;

//LOCALHOST:8080

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //Get -- Mandar requisição para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas";
    }

    //Post -- Mandar uma requisição para criar uma missao

    @PostMapping("/criar")
    public String criarMissao(){
        return "Criado missão";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Alterado a missao";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada";
    }





}
