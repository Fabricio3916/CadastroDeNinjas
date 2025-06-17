package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missaoNova = missoesMapper.map(missaoDTO);
        missaoNova = missoesRepository.save(missaoNova);
        return missoesMapper.map(missaoNova);
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoesListadas = missoesRepository.findAll();
        return missoesListadas.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());

    }

    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO alterarMissao(Long id, MissoesDTO missaoAtualizada){
       Optional<MissoesModel> missoesExistentes = missoesRepository.findById(id);
       if(missoesExistentes.isPresent()){
           MissoesModel missaoAlterada = missoesMapper.map(missaoAtualizada);
           missaoAlterada.setId(id);
           MissoesModel missaoSalva = missoesRepository.save(missaoAlterada);
           return missoesMapper.map(missaoSalva);
       }
       return null;
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }



}
