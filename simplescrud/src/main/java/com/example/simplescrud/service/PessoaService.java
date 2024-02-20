package com.example.simplescrud.service;

import com.example.simplescrud.model.PessoaModel;
import com.example.simplescrud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    public PessoaModel save(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    public Optional<PessoaModel> findById(int id){
        return pessoaRepository.findById(id);
    }

    public PessoaModel update(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    public void delete(int id){
        pessoaRepository.deleteById(id);
    }

}
