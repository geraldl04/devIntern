package dev.al.internship.Student;

import jakarta.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}