package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.BoardEntity;
import com.example.demo.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    private BoardRepository boardRepository;


    public List<BoardDto> getList(){

        List<BoardDto> boardDtoList = new ArrayList<>();

        //List<BoardEntity> boardEntityList = boardRepository.getList();

        for(BoardEntity boardEntity:boardRepository.getList()){
            boardDtoList.add(BoardDto.fromEntity(boardEntity));
        }
        return  boardDtoList;
    }

    public void update(BoardDto boardDto) throws Exception{

        logger.info("service");
        boardRepository.update(boardDto);
    }

    public void update(){

    }
}
