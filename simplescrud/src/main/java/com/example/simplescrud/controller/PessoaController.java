package com.example.simplescrud.controller;

import com.example.simplescrud.model.PessoaModel;
import com.example.simplescrud.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }
    //buscar todos
    @GetMapping("/all")
    public ResponseEntity<Object> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }
    // buscar pelo id
    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> getPessoaid(@PathVariable Integer id){
        return new ResponseEntity<>(pessoaService.findById(id).orElse(null), HttpStatus.OK);

    }
    // save
    @PostMapping("/save")
    public ResponseEntity<Void> savePessoas(@RequestBody PessoaModel pessoaModel){
        pessoaService.save(pessoaModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    // atualizar
    @PutMapping("/att")
    public ResponseEntity<Object> atualizar(@RequestBody PessoaModel pessoaModel){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoaModel));
    }
    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
