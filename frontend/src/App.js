import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';

const App = () => {

  const [clients, setClients] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('clients')
        .then(response => response.json())
        .then(data => {
          setClients(data);
          setLoading(false);
        })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Clients List</h2>
            {clients.map(group =>
                <div key={group.id}>
                  {group.name}
                </div>
            )}
          </div>
        </header>
      </div>
  );
}

export default App;