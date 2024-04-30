package com.example.demo.DTO;

import com.example.demo.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Setter
@Getter
public class BoardDto {
    private Integer id;

    private String title;
    private String contents;


    public BoardDto(Integer id,String title,String contents){
        this.id         = id;
        this.title      = title;
        this.contents   = contents;
    }

    public void fromEntity(BoardEntity boardEntity){
        this.id         = boardEntity.getId();
        this.title      = boardEntity.getTitle();
        this.contents   =   boardEntity.getContents();
    }

    public BoardEntity toEntity(){
        BoardEntity boardEntity = new BoardEntity(this.id,this.title,this.contents);
        return boardEntity;
    }
}
