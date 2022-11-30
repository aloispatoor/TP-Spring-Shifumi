package com.rockpaperscisors.rps.entity;

import javax.persistence.*;

@Entity
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @OneToOne
    @JoinColumn(name = "score_ID")
    private Score score;

    public Player() {
    }

    public Player(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}
