package com.example.demo.dto;

import com.example.demo.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardDto {
    private Integer id;

    private String title;
    private String contents;
    private String age;


    public BoardDto(String title,String contents){

        this.title      = title;
        this.contents   = contents;
    }

    public void fromEntity(BoardEntity boardEntity){
        this.id         = boardEntity.getId();
        this.title      = boardEntity.getTitle();
        this.contents   =   boardEntity.getContents();
    }

    public BoardEntity toEntity(){
        BoardEntity boardEntity = new BoardEntity() ;
        boardEntity.setTitle(this.title);
        boardEntity.setContents(this.contents);

        return boardEntity;
    }
}
