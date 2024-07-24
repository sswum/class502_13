package org.choongang.board.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BoardView {
    @Id @EmbeddedId
    private BoardViewId id;
}


/*
@IdClass(BoardViewId.class)
public class BoardView { //복합키를 생성
    @Id
    private long seq;
    @Id
    @Column(name="_uid")
    private int uid;
}


 */