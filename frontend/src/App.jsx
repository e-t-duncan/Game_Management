
import './App.css'
import { useState } from 'react'

import Players from './components/Players.jsx'
import Games from './components/Games.jsx'
import Tournaments from './components/Tournaments.jsx'

function App() {

    const [view, setView] = useState('players')

    return (
        <>
            <div>
                <button onClick={() => setView('players')}>
                    Players
                </button>

                <button onClick={() => setView('games')}>
                    Games
                </button>

                <button onClick={() => setView('tournaments')}>
                    Tournaments
                </button>
            </div>

            {view === 'players' && <Players />}

            {view === 'games' && <Games />}

            {view === 'tournaments' && <Tournaments />}
        </>
    )
}

export default App
