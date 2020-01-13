package com.devoops.service.board;


import com.devoops.domain.Board;
import com.devoops.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService implements BoardServiceImpl{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> listBoard(int category) {
        return  boardRepository.findByCategory(category);
    }
}
