import { useEffect, useState } from "react";

function Games() {

    const [games, setGames] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8091/api/games")
            .then(response => response.json())
            .then(data => {
                console.log(data)
                setGames(data);
            });
    }, []);

    return (
        <div>
            <h1>Games</h1>

            {games.map(game => (
                <div key={game.gameID}>
                    <h3>{game.gameTitle}</h3>
                    <h4>{game.gameGenre}</h4>
                </div>
            ))}
        </div>
    );
}

export default Games;