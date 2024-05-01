package com.example.demo.controller.Api;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/board")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private  final BoardService boardService ;   // final 일경우 반드시 생성자를 통한 초기화

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;    //변수가 동일하기에 this 사용
    }
    @GetMapping(value="/list/{id}")
    //public List<BoardDto> list(@PathVariable(value="id") String id,@RequestParam(value="page",required = false,defaultValue = "0") Integer page){
    public ResponseEntity list(@PathVariable(value="id") String id,@RequestParam(value="page",required = false,defaultValue = "0") Integer page){

        //public ResponseEntity list(@RequestParam(value="page",required = false,defaultValue = "0") Integer page){

        logger.info(String.valueOf(page));
        logger.info(id);
        List<BoardDto> boardDtoList = boardService.getList();
        //return new ResponseEntity(boardDtoList,new HttpHeaders(), HttpStatus.valueOf(200));
        return ResponseEntity.status(HttpStatus.CREATED).body(boardDtoList);
        //return boardDtoList;

    }

    @PostMapping(value="/update")
    public ResponseEntity update(@RequestBody BoardDto boardDto,@RequestParam(value = "age1",required = false) String age1) throws Exception{   //api에 사용 json 가능
    //public ResponseEntity update(@ModelAttribute BoardDto boardDto,@RequestParam(value = "age",required = false) String age, Model model) throws Exception{   // 주로 폼데이타에 사용
    //public  ResponseEntity update(@RequestParam(value="title") String title,@RequestParam(value = "contents") String contents) throws Exception{


        logger.info(boardDto.getTitle());
        //BoardDto boardDto = new BoardDto(title,contents);
        boardService.update(boardDto);

        logger.info(boardDto.getAge());
        /*
        logger.trace("Trace log");
        logger.debug("Debug log");
        logger.info("Info log");
        logger.error("Error log");
        logger.warn("Warn log");
        */
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(boardDto.getAge());
    }
}
