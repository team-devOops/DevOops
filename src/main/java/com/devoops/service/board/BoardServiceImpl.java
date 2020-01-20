package com.devoops.service.board;


import com.devoops.domain.Board;
import com.devoops.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private  final BoardRepository boardRepository;

    @Override
    public List<Board> listBoard(int category) {
        return  boardRepository.findByCategory(category);
    }
}
