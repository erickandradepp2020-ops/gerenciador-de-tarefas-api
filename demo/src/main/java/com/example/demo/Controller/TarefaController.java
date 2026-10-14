package com.example.demo.Controller;

import com.example.demo.model.Tarefas;
import com.example.demo.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public Tarefas criar(@RequestBody Tarefas tarefa) {
        tarefa.setId(null); // garante que será um INSERT
        return repository.save(tarefa);
    }

    // READ (todas)
    @GetMapping
    public List<Tarefas> listar() {
        return repository.findAll();
    }

    // READ (por id)
    @GetMapping("/{id}")
    public ResponseEntity<Tarefas> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Tarefas> atualizar(@PathVariable Long id,
                                             @RequestBody Tarefas dados) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setTitulo(dados.getTitulo());
            tarefa.setPrioridade(dados.getPrioridade());
            tarefa.setDataPrazo(dados.getDataPrazo());
            tarefa.setConcluida(dados.isConcluida());
            return ResponseEntity.ok(repository.save(tarefa));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}