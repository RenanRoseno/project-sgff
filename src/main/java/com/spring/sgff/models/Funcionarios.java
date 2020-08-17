/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sgff.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author rosen
 */
@Entity 
@Table(name="Funcionarios")

public class Funcionarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    private String cpf;
    
    @NotBlank
    private String rg;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataAdmissao;
    
    @NotBlank
    private int cargo;
    
    @NotBlank
    private String email;
    
}
