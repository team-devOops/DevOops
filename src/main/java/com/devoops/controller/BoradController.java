package com.devoops.controller;


import com.devoops.domain.Board;
import com.devoops.service.board.BoardService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")

public class BoradController {


    private BoardService boardService;


    @GetMapping("/list/{category}")
    public List<Board> list (@PathVariable Map<String,Object> pathVal){
    	return boardService.listBoard((Integer)pathVal.get("category"));
    }



}
