import { Button, TextField } from '@material-ui/core';
import React, { useState } from 'react'

function ScoreInput(props: {onSubmit: (name: string) => void}) {
  const [name, setName] = useState('')
  const submit = () => {
    props.onSubmit(name)
  }
  return (
    <form noValidate autoComplete="off">
      <TextField required id="name" label="Your Name" value={name} onChange={(e) => {setName(e.target.value)}} />
      <Button variant="contained" color="primary" onClick={submit}>Play!</Button>
    </form>  
  );
}

export default ScoreInput