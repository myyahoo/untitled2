package com.example.demo.DTO;

import com.example.demo.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Setter
@Getter
@NoArgsConstructor
public class BoardDto {
    private Integer id;

    private String title;
    private String contents;


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
