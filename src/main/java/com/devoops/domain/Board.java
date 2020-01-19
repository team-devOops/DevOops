package com.devoops.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_MST_BOARD")
public class Board extends BaseBoardVO {
	
    @Id
    @GeneratedValue
    private long id;
    private int category;
    private String title;
    private String context;
    private String mainPictures;
    
}