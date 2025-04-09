package com.app.todolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todolist.services.TaskService;
import com.app.todolist.models.Task;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("")
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";

    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@RequestBody Task task, @PathVariable Integer id) {
        taskService.toggleTask(task, id);
        return "redirect:/tasks";

    }

    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // @PutMapping("/{id}")
    // void update(@RequestBody Run run, @PathVariable Integer id){
    //     runRepository.update(run, id);
    // }



}


// package com.example.demo.run;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.DeleteMapping;


// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;
// // import org.springframework.web.server.ResponseStatusException;

// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/api/runs")
// public class RunController {

//     private final RunRepository runRepository;

//     public RunController(RunRepository runRepository){
//         this.runRepository = runRepository;
//     }

//     @GetMapping("")
//     List<Run> findAll(){
//         return runRepository.findAll();
//     }

//     @GetMapping("/{id}")
//     Run findById(@PathVariable Integer id){

//         Optional<Run> run = runRepository.findById(id);;
        
//         if(run.isEmpty()){
//             throw new RunNotFoundException();
//         }
//         return run.get();
//     }

//     // post
//     @ResponseStatus(HttpStatus.CREATED)
//     @PostMapping("")
//     void create(@Valid @RequestBody Run run){
//         runRepository.create(run);
//     }

//     // put
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//     @PutMapping("/{id}")
//     void update(@RequestBody Run run, @PathVariable Integer id){
//         runRepository.update(run, id);
//     }

//     // delete
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//     @DeleteMapping("/{id}")
//     void delete(@PathVariable Integer id){
//         runRepository.delete(id);
//     }
//     // @GetMapping("/hello")
//     // String home(){
//     //     return "Hello, runner!";
//     // }
// }
