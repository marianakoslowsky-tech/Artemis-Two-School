package com.example.demo.service;

import com.example.demo.repositories.alunorepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.aluno;

@Service
public class alunoservice {

@Autowired
private alunorepository alunoRepository;



 public Long contarAluno(){
        return alunoRepository.count();
    }
    public aluno buscarAluno(Integer id){
        return alunoRepository.findById(id).get();
    }
    public List<aluno> listUsuarios(){
        return alunoRepository.findAll();


    }
        public Boolean deletaraluno(Integer id){
            if(alunoRepository.existsById(id)){
      alunoRepository.deleteById(id);
                return true;
          }
        return false;

        }



        public aluno cadastrarUsuario(aluno aluno){
            return alunoRepository.save(aluno);
        }


        public aluno atualizaUsuario(Integer id, aluno aluno ){
            aluno alunoRecuperado = buscarAluno(id);
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




