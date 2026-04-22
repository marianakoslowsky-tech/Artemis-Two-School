package com.example.demo.service;

import com.example.demo.models.Aluno;
import com.example.demo.repositories.alunorepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class alunoservice {

@Autowired
private alunorepository alunoRepository;



 public Long contarAluno(){
        return alunoRepository.count();
    }
    public Aluno buscarAluno(Integer id){
        return alunoRepository.findById(id).get();
    }

    public List<Aluno> listAlunos(){
        return alunoRepository.findAll();


    }
        public Boolean deletaraluno(Integer id){
            if(alunoRepository.existsById(id)){
      alunoRepository.deleteById(id);
                return true;
          }
        return false;

        }



        public Aluno cadastrarUsuario(Aluno aluno){
            return alunoRepository.save(aluno);
        }


        public Aluno atualizaAluno(Integer id, Aluno aluno ){
            Aluno alunoRecuperado = buscarAluno(id);
            if(alunoRecuperado != null){
                alunoRecuperado.setId(id);
                if (aluno.getNome() != null){
                    alunoRecuperado.setNome(aluno.getNome());
                }
                if(aluno.getDataNascimento()!=null){
                    alunoRecuperado.setDataNascimento
                    (alunoRecuperado.getDataNascimento());

                }
                return alunoRepository.save(alunoRecuperado);
            }
            return null;

        }


    }




