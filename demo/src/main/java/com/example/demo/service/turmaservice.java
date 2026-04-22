package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.turma;
import com.example.demo.repositories.turmarepository;

@Service
public class turmaservice{

@Autowired
private turmarepository turmaRepository;

public Long contarturma() {
    return turmaRepository.count();

}
 public turma buscarturma(Integer id) {
    return turmaRepository.findById(id).get();

}
public List<turma> listturma() {
    return turmaRepository.findAll();

}
public Boolean deletarturma(Integer id) {
    if (turmaRepository.existsById(id)) {
        turmaRepository.deleteById(id);
        return true; 
    }
    return false;
}

public turma cadastrarTurma(turma turma) {
    return turmaRepository.save(turma);

  }
public turma atualizarTurma(Integer id, turma turma){
    turma turmarecuperada = buscarturma(id);
if (turmarecuperada != null) {
    turmarecuperada.setId(id);
    if(turma.getNome()!=null){
       turmarecuperada.setNome(turma.getNome());
    }
    return turmaRepository.save(turmarecuperada);
  }
  return null;

}

}
















    





    

