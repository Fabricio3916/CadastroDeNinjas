package dev.java10x.CadastroDeNinja.Missoes;

//LOCALHOST:8080

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Get -- Mandar requisição para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
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
