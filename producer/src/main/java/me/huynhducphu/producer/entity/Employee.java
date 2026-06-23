package me.huynhducphu.producer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Admin 6/21/2026
 *
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    Long id;

    String username;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDay;

}
