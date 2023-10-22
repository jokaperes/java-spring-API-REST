package com.sic.listatarefas.services;

import com.sic.listatarefas.model.Tarefa;
import com.sic.listatarefas.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TarefaService {
    final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    public List<Tarefa> getAll(){
        return tarefaRepository.findAll();
    }
    public Tarefa getByID(Integer id){
        return tarefaRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("Nao foi encontrada uma tarefa com o id: " + id));
    }
    public Tarefa save(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
    public void deleteById(Integer id){
        tarefaRepository.deleteById(id);
    }
}
