package com.example.demo.service;

import com.example.demo.DTO.BoardDto;
import com.example.demo.Dao.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;


    public List<BoardDto> getList(){

        List<BoardDto> boardDtoList = boardDao.getList();
        return  boardDtoList;
    }
}
