package dev.java10x.CadastroDeNinja.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

//Entity transforma uma classe em uma entidade do Banco de Dados
//JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @ManyToOne // Many missoes para One Ninja
    @JoinColumn(name = "missoes_id") //Chave estrangeira
    @JsonIgnore // impede mostrar as missoes de forma repetida ao exibir as missoes
    private MissoesModel missoes;


}
