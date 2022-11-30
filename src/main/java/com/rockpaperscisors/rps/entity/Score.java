package com.rockpaperscisors.rps.entity;

import javax.persistence.*;

@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private int win;
    private int lose;
    private int tie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Score() {
    }

    public Score(int win, int lose, int tie) {
        super();
        this.win = win;
        this.lose = lose;
        this.tie = tie;
    }

    public int getWin() {
        return win;
    }
    public void setWin(int win) {
        this.win = win;
    }
    public int getLose() {
        return lose;
    }
    public void setLose(int lose) {
        this.lose = lose;
    }
    public int getTie() {
        return tie;
    }
    public void setTie(int tie) {
        this.tie = tie;
    }

    public void addWin() {
        this.win++;
    }
    public void addLose() {
        this.lose++;
    }
    public void addTie() {
        this.tie++;
    }

    public int nbGames(int win,int lose,int tie){
        return this.win + this.lose + this.tie;
    }
}
