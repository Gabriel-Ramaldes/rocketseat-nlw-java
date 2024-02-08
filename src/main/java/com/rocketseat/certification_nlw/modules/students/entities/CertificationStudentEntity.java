package com.rocketseat.certification_nlw.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="certifications")
@Builder
public class CertificationStudentEntity {

     @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column(name ="student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name="student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @Column(length= 100)
    private String technology;
    @Column(length= 10)
    private int grade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "awnser_certification_id", insertable = false, updatable = false)
    @JsonManagedReference
    private List<AnswersCertificationsEntity> answersCerticationsEntity;

     @CreationTimestamp
    private LocalDateTime createdAt;
    
}
