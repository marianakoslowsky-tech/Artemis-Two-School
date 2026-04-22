package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.turma;
import com.example.demo.service.turmaservice;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    
    @Autowired
    private turmaservice turmaService;

    @GetMapping("/contar-turma")
    public Long contarTurma(){
        return turmaService.contarturma();
    }

    @GetMapping("/buscar-turma/{id}")
    public turma buscarTurma(@PathVariable Integer id){
        return turmaService.buscarturma(id);
    }

    @GetMapping("listar-turma")
    public List<turma> listarTurmas(){
        return turmaService.listturma();
    }

    @DeleteMapping("/deletar-turma/{id}")
    public String deletarTurma(@PathVariable Integer id){
        if (turmaService.deletarturma(id)) {
            return "Turma excluída com sucesso";
        }
        return "Falha na exclusão da turma";
    }

    @PostMapping("/salvar-turma")
    public turma cadastrarTurma(@RequestBody turma turma){
        return turmaService.cadastrarTurma(turma);
    }

    @PutMapping("atualizar-turma/{id}")
    public String atualizarTurma(@PathVariable Integer id, @RequestBody turma turma){
        if (turmaService.atualizarTurma(id, turma) != null) {
            return "Turma atualizada com sucesso";
        }
        return "Falha na atualização da Turma";
    }


}

