package com.devoops.service.board;

import com.devoops.domain.Board;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    List<Board> listBoard(int category, Pageable pageable);
}
