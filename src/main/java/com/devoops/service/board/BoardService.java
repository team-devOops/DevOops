package com.devoops.service.board;

import com.devoops.domain.Board;

import java.util.List;

public interface BoardService {

    public List<Board> listBoard(int category);
}
