package com.devoops.service.board;

import com.devoops.domain.Board;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    public List<Board> listBoard(int category, Pageable pageable);
}
