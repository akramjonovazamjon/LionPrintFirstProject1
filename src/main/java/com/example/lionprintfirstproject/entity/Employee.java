package com.example.lionprintfirstproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Department department;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Job job;
}
