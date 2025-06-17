package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //mostrar todos os ninjas(Read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar todos os ninjas por Id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado");
        }
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}") // o metodo PUT altera todos os campos, nao apenas os que vc pede para alterar
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id,  @RequestBody NinjaDTO ninjaAtualizado ){
       NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
       if(ninja != null){
           return ResponseEntity.ok(ninja);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("O ninja com o id " + id + " não foi encontrado");
       }
    }

    //Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com id: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado");
        }

    }




}
