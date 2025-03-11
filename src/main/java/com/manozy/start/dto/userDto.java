package com.manozy.start.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class userDto {
    private int id;
    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 10,message = "Name Should Be between 3 and 20 characters")
    private String name;
    @NotNull(message = "Age cannot be null")
    private int age;
}
