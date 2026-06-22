import { useEffect, useState } from "react";
import "../assets/Games.css";

function Games() {

    const [games, setGames] = useState([]);

    const [showForm, setShowForm] = useState(false);
    const [newGame, setNewGame] = useState({
        gameTitle: "",
        gameGenre: "",
        platform: "",
        releaseDate: ""
    });

    const [editingGame, setEditingGame] = useState(null);
    const [editGame, setEditGame] = useState({
        gameTitle: "",
        gameGenre: "",
        platform: "",
        releaseDate: ""
    });

    const platforms = [
        "Console Exclusive",
        "PC Exclusive",
        "Console and PC"
    ];


    useEffect(() => {

        fetch("http://localhost:8091/api/games")
            .then(response => response.json())
            .then(data => {
                setGames(data);
            });

    }, []);

    function handleChange(e) {

        setNewGame({
            ...newGame,
            [e.target.name]: e.target.value
        });

    }

    function handleEditChange(e) {

        setEditGame({
            ...editGame,
            [e.target.name]: e.target.value
        });

    }

    function deleteGame(gameID) {

        fetch(`http://localhost:8091/api/games/${gameID}`, {

            method: "DELETE"

        })

            .then(response => {

                if(response.ok) {

                    setGames(
                        games.filter(game => game.gameID !== gameID)
                    );

                }

            });

    }

    function startEditing(game) {

        setEditingGame(game.gameID);

        setEditGame({
            gameTitle: game.gameTitle,
            gameGenre: game.gameGenre,
            platform: game.platform,
            releaseDate: game.releaseDate
        });

    }

    function updateGame(id) {


        fetch(`http://localhost:8091/api/games/${id}`, {

            method: "PATCH",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(editGame)

        })


            .then(response => response.json())

            .then(updatedGame => {


                setGames(
                    games.map(game =>
                        game.gameID === id
                            ? updatedGame
                            : game
                    )
                );


                setEditingGame(null);

            });

    }

    function addGame() {


        fetch("http://localhost:8091/api/games", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(newGame)

        })


            .then(response => response.json())

            .then(game => {


                setGames([
                    ...games,
                    game
                ]);


                setShowForm(false);


                setNewGame({
                    gameTitle: "",
                    gameGenre: "",
                    platform: "",
                    releaseDate: ""
                });

            });

    }



    return (

        <div className="games-container">


            <h1>Games</h1>


            <button
                className="add-button"
                onClick={() => setShowForm(true)}
            >
                Add Game
            </button>
            {showForm && (

                <div className="game-form">


                    <input
                        name="gameTitle"
                        placeholder="Game title"
                        value={newGame.gameTitle}
                        onChange={handleChange}
                    />


                    <input
                        name="gameGenre"
                        placeholder="Genre"
                        value={newGame.gameGenre}
                        onChange={handleChange}
                    />


                    <select
                        name="platform"
                        value={newGame.platform}
                        onChange={handleChange}
                    >
                        <option value="">
                            Select Platform
                        </option>
                        {platforms.map(platform => (

                            <option
                                key={platform}
                                value={platform}
                            >
                                {platform}
                            </option>

                        ))}

                    </select>


                    <input
                        name="releaseDate"
                        type="date"
                        value={newGame.releaseDate}
                        onChange={handleChange}
                    />


                    <button onClick={addGame}>
                        Save Game
                    </button>


                </div>

            )}

            <div className="games-grid">


                {games.map(game => (

                    <div className="game-card" key={game.gameID}>


                        {editingGame === game.gameID ? (

                            <div>


                                <input
                                    name="gameTitle"
                                    value={editGame.gameTitle}
                                    onChange={handleEditChange}
                                />


                                <input
                                    name="gameGenre"
                                    value={editGame.gameGenre}
                                    onChange={handleEditChange}
                                />


                                <select
                                    name="platform"
                                    value={editGame.platform}
                                    onChange={handleEditChange}
                                >
                                    {platforms.map(platform => (

                                        <option
                                            key={platform}
                                            value={platform}
                                        >
                                            {platform}
                                        </option>

                                    ))}


                                </select>


                                <input
                                    type="date"
                                    name="releaseDate"
                                    value={editGame.releaseDate}
                                    onChange={handleEditChange}
                                />


                                <button
                                    onClick={() => updateGame(game.gameID)}
                                >
                                    Save
                                </button>


                                <button
                                    onClick={() => setEditingGame(null)}
                                >
                                    Cancel
                                </button>


                            </div>


                        ) : (


                            <>


                                <h2>
                                    {game.gameTitle}
                                </h2>


                                <p>
                                    Genre: {game.gameGenre}
                                </p>


                                <p>
                                    Platform: {game.platform}
                                </p>


                                <p>
                                    Released: {game.releaseDate}
                                </p>


                                <button
                                    onClick={() => startEditing(game)}
                                >
                                    Edit
                                </button>


                                <button
                                    className="delete-button"
                                    onClick={() => deleteGame(game.gameID)}
                                >
                                    Delete
                                </button>


                            </>

                        )}


                    </div>

                ))}


            </div>


        </div>

    );
}


export default Games;