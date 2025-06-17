package dev.java10x.CadastroDeNinja.Missoes;

//LOCALHOST:8080

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Post -- Mandar uma requisição para criar uma missao
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    //Get -- Mandar requisição para mostrar as missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoesListadas = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesListadas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        MissoesDTO missoes = missoesService.listarMissaoPorId(id);
        if(missoes != null){
            return ResponseEntity.ok(missoes);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão de id " + id + " não existe em nossos registros!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missoes = missoesService.alterarMissao(id,missaoAtualizada);
       if (missoes != null){
           return ResponseEntity.ok(missoes);
       }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("A missão de id " + id + " não existe em nossos registros!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable  Long id){
        MissoesDTO missoes = missoesService.listarMissaoPorId(id);
        if(missoes != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("A missão de id " + id + " foi deletada com sucesso!");
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A missão de id " + id + " não existe em nossos registros!");
    }









}
