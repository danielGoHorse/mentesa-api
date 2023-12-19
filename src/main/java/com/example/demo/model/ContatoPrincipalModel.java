package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "tb_contato_principal")
public class ContatoPrincipalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "grau_parentesco")
    private String grauParentesco;

//    @ManyToOne
//    @JoinColumn(name = "id_usuario")
//    private Usuario idUsuario;
}
