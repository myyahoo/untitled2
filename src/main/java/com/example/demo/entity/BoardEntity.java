package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@Table(name="board")
@NoArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    private String contents;

/*
    @Builder
    public BoardEntity(Integer id,String title,String contents){
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

 */
}
