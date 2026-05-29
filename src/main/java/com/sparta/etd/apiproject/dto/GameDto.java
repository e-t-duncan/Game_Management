package com.sparta.etd.apiproject.dto;

import java.time.LocalDate;

public class GameDto {

    private Integer gameID;
    private String gameTitle;
    private String gameGenre;
    private LocalDate releaseDate;
    private String platform;

    public GameDto(Integer gameID, String gameTitle, String gameGenre, LocalDate releaseDate, String platform) {
        this.gameID = gameID;
        this.gameTitle = gameTitle;
        this.gameGenre = gameGenre;
        this.releaseDate = releaseDate;
        this.platform = platform;
    }

    public GameDto() {
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
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
}
