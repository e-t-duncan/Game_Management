package com.sparta.etd.apiproject.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GameID", nullable = false)
    private int gameID;

    @Column(name = "Title", length = 50)
    private String gameTitle;

    @Column(name = "Genre", length = 50)
    private String gameGenre;

    @Column(name = "ReleaseDate", length = 10)
    private LocalDate releaseDate;

    @Column(name = "Platform", length = 25)
    private String platform;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Tournament> tournaments;

    public Game(String gameTitle, String gameGenre, LocalDate releaseDate, String platform) {
        this.gameTitle = gameTitle;
        this.gameGenre = gameGenre;
        this.releaseDate = releaseDate;
        this.platform = platform;
    }

    public Game() {
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
}
