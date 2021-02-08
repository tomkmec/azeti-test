import { Container } from '@material-ui/core';
import React, { useState } from 'react';
import * as api from './api'

import ScoreInput from './ScoreInput'
import YourScore from './YourScore'
import ScoreResults from './ScoreResults'

function App() {
  const [results, setResults] = useState([] as Score[])
  const [latest, setLatest] = useState(false as Score|false)

  const submit = async (name: string) => {
    api.submit({name})
      .then((score) => {
        setLatest(score);
        return api.getAll();
      }).then(setResults)
  }

  return (
    <Container maxWidth="md">
      <ScoreInput onSubmit={submit} />
      <YourScore score={latest} />
      <ScoreResults data={results} latest={latest} />
    </Container>
  );
}

export default App;
