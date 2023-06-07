package br.com.diego.layout.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.layout.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Você pode adicionar métodos personalizados do repositório aqui, se necessário
}


