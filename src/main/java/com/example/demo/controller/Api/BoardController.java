package com.example.demo.controller.Api;

import com.example.demo.DTO.BoardDto;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/api/board/list")
    public ResponseEntity list(@RequestParam(value="page",required = false,defaultValue = "0") Integer page){

        List<BoardDto> boardDtoList = boardService.getList();
        return new ResponseEntity(boardDtoList,new HttpHeaders(), HttpStatus.valueOf(200));
    }
}
