package com.devoops.controller;


import com.devoops.domain.Board;
import com.devoops.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/list/{category}")
    public List<Board> list (@PathVariable Map<String,Object> pathVal){
        return boardService.listBoard(Integer.parseInt(pathVal.get("category").toString()));
    }




}