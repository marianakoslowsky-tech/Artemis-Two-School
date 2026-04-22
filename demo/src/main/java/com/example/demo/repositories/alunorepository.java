package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Aluno;

@Repository
public interface alunorepository extends JpaRepository <Aluno, Integer> {

    
} 