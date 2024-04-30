package com.example.demo.controller.Api;

import com.example.demo.DTO.BoardDto;
import com.example.demo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;


    @GetMapping("/api/board/list")
    public ResponseEntity list(@RequestParam(value="page",required = false,defaultValue = "0") Integer page){
        logger.info("Info log");
        List<BoardDto> boardDtoList = boardService.getList();
        return new ResponseEntity(boardDtoList,new HttpHeaders(), HttpStatus.valueOf(200));
    }

    @PostMapping("/api/board/update")
    //public ResponseEntity update(@RequestBody BoardDto boardDto,@RequestParam(value = "age",required = false) String age) throws Exception{   //json 가능
    public ResponseEntity update(@ModelAttribute BoardDto boardDto,@RequestParam(value = "age",required = false) String age) throws Exception{
    //public  ResponseEntity update(@RequestParam(value="title") String title,@RequestParam(value = "contents") String contents) throws Exception{


        logger.info(boardDto.getTitle());
        //BoardDto boardDto = new BoardDto(title,contents);
        boardService.update(boardDto);

        logger.trace("test");
        /*
        logger.trace("Trace log");
        logger.debug("Debug log");
        logger.info("Info log");
        logger.error("Error log");
        logger.warn("Warn log");
        */
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(age);
    }
}
