package com.example.demo.service;

import com.example.demo.DTO.BoardDto;
import com.example.demo.Dao.BoardDao;
import com.example.demo.controller.Api.BoardController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Autowired
    private BoardDao boardDao;


    public List<BoardDto> getList(){

        List<BoardDto> boardDtoList = boardDao.getList();
        return  boardDtoList;
    }

    public void update(BoardDto boardDto) throws Exception{

        logger.info("service");
        boardDao.update(boardDto);
    }
}
