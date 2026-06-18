import { useEffect, useState } from "react";

function Tournaments() {

    const [tournaments, setTournaments] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8091/api/tournaments")
            .then(response => response.json())
            .then(data => {
                setTournaments(data);
            });
    }, []);

    return (
        <div>
            <h1>Tournaments</h1>

            {tournaments.map(tournament => (
                <div key={tournament.tournamentID}>
                    <h3>{tournament.tournamentName}</h3>
                    <h2>{tournament.startDate}</h2>
                </div>
            ))}
        </div>
    );
}

export default Tournaments;