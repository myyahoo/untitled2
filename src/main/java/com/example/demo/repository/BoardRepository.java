package com.example.demo.repository;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.BoardEntity;
import com.example.demo.service.BoardService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Repository
public class BoardRepository {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final SqlSession sqlSession;

    @Autowired
    public BoardRepository(SqlSession sqlSession){
        this.sqlSession =sqlSession;
    }

    public List<BoardEntity> getList(){

        BoardDto boardDto;

        HashMap<String, Object> data = new HashMap<>();

        data.put("keyword","");
        data.put("startNo",0);
        data.put("listOffset",10);
        List<BoardEntity> boardEntities = sqlSession.selectList("mappers.board-mapper.getList", data);

        Integer totalCnt = sqlSession.selectOne("mappers.board-mapper.getTotalCnt");

        logger.info(String.valueOf(totalCnt));
/*
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(BoardEntity boardEntity:boardEntities){
            boardDtoList.add(new BoardDto(boardEntity.getTitle(), boardEntity.getContents()));

        }*/
        return boardEntities;
    }

    public Integer update(BoardDto boardDto) throws Exception{

        BoardEntity boardEntity = boardDto.toEntity();
        return sqlSession.insert("mappers.board-mapper.insertBoard",boardEntity);
    }
}
