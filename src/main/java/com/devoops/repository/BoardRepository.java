package com.devoops.repository;


import com.devoops.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,String> {

    public List<Board> findByCategory(int category);

}
