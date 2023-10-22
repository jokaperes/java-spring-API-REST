package com.sic.listatarefas.controllers;

import com.sic.listatarefas.model.Tarefa;
import com.sic.listatarefas.services.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class TarefaController {
    final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
    @GetMapping("/tarefas")
    public List<Tarefa> getAll(){
        return tarefaService.getAll();

    }
    @GetMapping("/tarefas/{id}")
    public ResponseEntity<?> getTarefaById(@PathVariable Integer id){
        try{

            Tarefa tarefa = tarefaService.getByID(id);
            return ResponseEntity.ok(tarefa);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping("/tarefas")
    public ResponseEntity<?> save(@RequestBody @Valid Tarefa tarefa){
        try{
            tarefa = tarefaService.save(tarefa);
            return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try{
            tarefaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();

        }
    }
}
