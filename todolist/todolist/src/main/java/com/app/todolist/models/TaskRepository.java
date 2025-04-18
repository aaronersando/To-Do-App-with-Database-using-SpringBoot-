package com.app.todolist.models;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class TaskRepository {

    private final JdbcClient jdbcClient;

    
    public TaskRepository(JdbcClient jdbcClient) {
                this.jdbcClient = jdbcClient;
            }

    public List<Task> findAll() {
        return jdbcClient.sql("select * from task")
                .query(Task.class)
                .list();
    }

    public void save(Task task) {
                var updated = jdbcClient.sql("insert into task(title, completed) values (?, ?)")
                        .params(List.of(task.title(), task.completed()))
                        .update();
        
                Assert.state(updated == 1, "Failed to update run " + task.title());
            }

    public void deleteById(Integer id) {
        var deleted = jdbcClient.sql("delete from task where id = :id")
                        .param("id", id)
                        .update();
        
                Assert.state(deleted == 1, "Failed to delete run with id " + id);
            }

            public void updateById(Integer id) {
                var updated = jdbcClient.sql("UPDATE task SET completed = NOT completed WHERE id = ?")
                                .params(List.of(id))
                                .update();
            
                Assert.state(updated == 1, "Failed to toggle task with id " + id);
            }

    // public void update(Run run, Integer id) {
        //         var updated = jdbcClient.sql("update run set title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? where id = ?")
        //                 .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
        //                 .update();
        
        //         Assert.state(updated == 1, "Failed to update run " + run.title());
        //     }

    // public void delete(Integer id) {
        //         var deleted = jdbcClient.sql("delete from run where id = :id")
        //                 .param("id", id)
        //                 .update();
        
        //         Assert.state(deleted == 1, "Failed to delete run with id " + id);
        //     }

    
    
}


// package com.example.demo.run;

// import java.time.LocalDateTime;
// import java.time.temporal.ChronoUnit;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
// import org.springframework.jdbc.core.simple.JdbcClient;
// import org.springframework.stereotype.Repository;
// import org.springframework.util.Assert;

// import jakarta.annotation.PostConstruct;

// @Repository
// public class RunRepository {

//     private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
//     private final JdbcClient jdbcClient;

//     public RunRepository(JdbcClient jdbcClient) {
//         this.jdbcClient = jdbcClient;
//     }

//     public List<Run> findAll() {
//         return jdbcClient.sql("select * from run")
//                 .query(Run.class)
//                 .list();
//     }

//     public Optional<Run> findById(Integer id) {
//         return jdbcClient.sql("select * from run where id = :id")
//                 .param("id", id)
//                 .query(Run.class)
//                 .optional();
//     }

//     public void create(Run run) {
//         var updated = jdbcClient.sql("insert into Run(id, title, started_on, completed_on, miles, location) values (?, ?, ?, ?, ?, ?)")
//                 .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
//                 .update();

//         Assert.state(updated == 1, "Failed to update run " + run.title());
//     }

//     public void update(Run run, Integer id) {
//         var updated = jdbcClient.sql("update run set title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? where id = ?")
//                 .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
//                 .update();

//         Assert.state(updated == 1, "Failed to update run " + run.title());
//     }

//     public void delete(Integer id) {
//         var deleted = jdbcClient.sql("delete from run where id = :id")
//                 .param("id", id)
//                 .update();

//         Assert.state(deleted == 1, "Failed to delete run with id " + id);
//     }

//     public int count() {
//         return jdbcClient.sql("select * from run").query().listOfRows().size();
//     }

//     public void saveAll(List<Run> runs){
//         runs.stream().forEach(this::create);
//     }

//     public List<Run> findByLocation(String Location){
//         return jdbcClient.sql("select * from run where location = :location")
//                 .param("location", Location)
//                 .query(Run.class)
//                 .list();
//     }
// }
