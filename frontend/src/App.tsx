import { Container, makeStyles } from '@material-ui/core';
import React, { useEffect, useState } from 'react';
import * as api from './api'

import ScoreInput from './ScoreInput'
import YourScore from './YourScore'
import ScoreResults from './ScoreResults'

const useStyles = makeStyles({
  container: {
    paddingTop: '2em'
  }
})

function App() {
  const classes = useStyles()

  const [results, setResults] = useState([] as Score[])
  const [latest, setLatest] = useState(false as Score|false)

  const submit = async (name: string) => {
    api.submit({name})
      .then((score) => {
        setLatest(score);
        return api.getAll();
      }).then(setResults)
  }

  useEffect(() => {
    api.getAll().then(setResults)
  },[])

  return (
    <Container maxWidth="sm" className={classes.container}>
      <ScoreInput onSubmit={submit} />
      <YourScore score={latest} />
      <ScoreResults data={results} latest={latest} />
    </Container>
  );
}

export default App;
