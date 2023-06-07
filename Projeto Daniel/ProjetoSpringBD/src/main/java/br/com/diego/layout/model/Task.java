package br.com.diego.layout.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import org.springframework.validation.annotation.Validated;

import io.micrometer.common.lang.NonNull;


@Entity
@Table(name = "tasks")
@Validated
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "title")
    @NonNull
    private String title;
    @Column(name = "description")
    @NonNull
    private String description;
    
    @Column(name = "dueDate")
    @NonNull
    private LocalDate dueDate;

    // Construtores, getters e setters

    public Task() {
    }

    public Task(Long id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }
}
