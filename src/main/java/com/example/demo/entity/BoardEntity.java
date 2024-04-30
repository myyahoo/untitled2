package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Getter
@Setter
@NoArgsConstructor
public class BoardEntity {
    protected Integer id;
    private String title;
    private String contents;


    @Builder
    public BoardEntity(Integer id,String title,String contents){
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
