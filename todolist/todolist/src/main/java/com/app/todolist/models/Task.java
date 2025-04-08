package com.app.todolist.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.With;

// U Don't actually need lombok if you're using record classes
// But a benefit of using it even with records is that you can use @Builder and @With annotations that makes it easy
// to create instances of the class and modify them immutably.

@Builder
@With
public record Task(
    Integer id,
    @NotEmpty
    String title,
    @Positive
    boolean completed
) {
}

// package com.example.demo.run;

// import java.time.LocalDateTime;

// import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.Positive;

// public record Run(
//     Integer id,
//     @NotEmpty
//     String title,
//     LocalDateTime startedOn,
//     LocalDateTime completedOn,
//     @Positive
//     Integer miles,
//     Location location
// ) {
//     public Run{
//         if(!completedOn.isAfter(startedOn)){
//             throw new IllegalArgumentException("Completed On must be after Started On");
//         }
//     }

// }
