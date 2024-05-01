package com.example.demo.repository;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.BoardEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class BoardRepository {

    private final SqlSession sqlSession;

    @Autowired
    public BoardRepository(SqlSession sqlSession){
        this.sqlSession =sqlSession;
    }

    public List<BoardDto> getList(){

        BoardDto boardDto;

        HashMap<String, Object> data = new HashMap<>();

        data.put("keyword","");
        data.put("startNo",0);
        data.put("listOffset",10);
        List<BoardEntity> boardEntities = sqlSession.selectList("mappers.board-mapper.getList", data);


        List<BoardDto> boardDtoList = new ArrayList<>();

        for(BoardEntity boardEntity:boardEntities){
            boardDtoList.add(new BoardDto(boardEntity.getTitle(), boardEntity.getContents()));

        }
        return boardDtoList;
    }

    public Integer update(BoardDto boardDto) throws Exception{

        BoardEntity boardEntity = boardDto.toEntity();
        return sqlSession.insert("mappers.board-mapper.insertBoard",boardEntity);
    }
}