package com.example.demo.controllers;

import java.util.List;

import javax.swing.GroupLayout.Alignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Aluno;
import com.example.demo.service.alunoservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping
public class AlunoControllers {

@Autowired
private alunoservice alunoService;


@GetMapping("/contar-alunos")
public Long contarAlunos(@PathVariable Integer id) {
    return alunoService.contarAluno();
}

@GetMapping("/buscar/{id}")
public Aluno buscarAluno (@PathVariable Integer id) {
    return alunoService.buscarAluno(id);
}

@GetMapping("List-alunos")
public List<Aluno> listAlunos() {
    return alunoService.listAlunos();
}

@DeleteMapping("/deletar-aluno/{id}")
public String deletarAluno(@PathVariable Integer id) {
    if  (alunoService.deletaraluno(id)) {
        return"Aluno deletado com sucesso";
    }
    return "Falha ao deletar o Aluno";
                  
}

@PostMapping("/salvar-aluno")
public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
    return alunoService.cadastrarUsuario(aluno);
}

@PutMapping("atualizar-aluno/{id}")
public String atualizarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
    if (alunoService.atualizaAluno(id,aluno) != null) {
        return "Aluno atualizado com sucesso";
    }

    return "Falha ao atualizar o Aluno";

}










}

    

