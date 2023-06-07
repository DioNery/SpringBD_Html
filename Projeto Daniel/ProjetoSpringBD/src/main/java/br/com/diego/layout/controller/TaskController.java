package br.com.diego.layout.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import br.com.diego.layout.model.Task;
import br.com.diego.layout.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;
  
  @GetMapping
  public String getAllTasks(Model model) {
      List<Task> taskList = taskService.getAllTasks();
      model.addAttribute("tasks", taskList);
      return "list";
}

  
  @GetMapping("/{id}")
  public String getTaskById(@PathVariable Long id, Model model) {
      Task task = taskService.getTaskById(id);
      model.addAttribute("task", task);
      return "task";
  }
  
  @GetMapping("/create")
  public String showCreateTaskForm(Model model) {
      model.addAttribute("task", new Task());
      return "create";
  }
  
  @PostMapping("/create")
public String createTask(@ModelAttribute("task") Task task, @RequestParam("dueDate") String dueDate) {
    LocalDate dueDateValue = LocalDate.parse(dueDate); // Converte a string em LocalDate
    task.setDueDate(dueDateValue);

    taskService.createTask(task);
    return "redirect:/tasks/list";
}


@GetMapping("/list")
public String getTaskList(Model model) {
    List<Task> taskList = taskService.getAllTasks();
    model.addAttribute("tasks", taskList);
    return "list";
}


  
  @GetMapping("/{id}/edit")
  public String showEditTaskForm(@PathVariable Long id, Model model) {
      Task task = taskService.getTaskById(id);
      model.addAttribute("task", task);
      return "edit-task";
  }
  
  @PostMapping("/{id}/edit")
  public String editTask(@PathVariable Long id, @ModelAttribute("task") Task task) {
      taskService.updateTask(id, task);
      return "redirect:/tasks";
  }
  
  @PostMapping("/{id}/delete")
  public String deleteTask(@PathVariable Long id) {
      taskService.deleteTask(id);
      return "redirect:/tasks";
  }
  
}

