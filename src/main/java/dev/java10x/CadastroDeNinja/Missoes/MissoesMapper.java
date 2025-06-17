package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missao = new MissoesModel();
        missao.setId(missoesDTO.getId());
        missao.setNome(missoesDTO.getNome());
        missao.setDificuldade(missoesDTO.getDificuldade());
        missao.setNinjas(missoesDTO.getNinjas());

        return missao;
    }

    public MissoesDTO  map(MissoesModel missoesModel){
        MissoesDTO missao = new MissoesDTO();
        missao.setId(missoesModel.getId());
        missao.setNome(missoesModel.getNome());
        missao.setDificuldade(missoesModel.getDificuldade());
        missao.setNinjas(missoesModel.getNinjas());

        return missao;
    }



}
