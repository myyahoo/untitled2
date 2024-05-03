package com.example.demo.dto;

import com.example.demo.entity.BoardEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//final이나 @NonNull인 필드 값만 파라미터로 받는 생성자
//@RequiredArgsConstructor
public class BoardDto {
    private Integer id;

    @NotBlank
    @NotNull
    private String title;

    private String contents;
    private String age;


    public  static BoardDto fromEntity(BoardEntity boardEntity){
        BoardDto boardDto = new BoardDto();

        boardDto.setId(boardEntity.getId());
        boardDto.setTitle(boardEntity.getTitle());
        boardDto.setContents(boardEntity.getContents());

        return boardDto;
    }

    public BoardEntity toEntity(){
        BoardEntity boardEntity = new BoardEntity() ;
        boardEntity.setTitle(this.title);
        boardEntity.setContents(this.contents);

        return boardEntity;
    }
}
