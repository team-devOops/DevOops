package com.devoops.controller;


import com.devoops.domain.Board;
import com.devoops.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoradController {

    @Autowired
    BoardService boardService;


    @GetMapping("/list/{category}")
    public List<Board> list (@PathVariable Map<String,Object> pathVal){
    	return boardService.listBoard((Integer)pathVal.get("category"));
    }

    @PostMapping("one")
    public int saveOne(@RequestParam Board board){

    }


}
