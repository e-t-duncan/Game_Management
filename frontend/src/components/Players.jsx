import { useEffect, useState } from "react";

function Players() {
    const [players, setPlayers] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8091/api/players")
            .then(response => response.json())
            .then(data => {
                setPlayers(data._embedded.playerDtoList);
            });
    }, []);

    return (
        <>
            <h1>Players</h1>

            {players.map(player => (
                <div key={player.playerID}>
                    <h3>{player.playerName}</h3>
                    <p>Level: {player.playerLevel}</p>
                    <p>Email: {player.email}</p>
                </div>
            ))}
        </>
    );
}

export default Players;