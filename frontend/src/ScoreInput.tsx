import { Button, makeStyles, TextField } from '@material-ui/core';
import React, { FormEvent, useState } from 'react'

const useStyles = makeStyles({
  button: {
    margin: '2em auto',
    display: 'block'
  }
})

function ScoreInput(props: {onSubmit: (name: string) => void}) {
  const classes = useStyles()

  const [name, setName] = useState('')
  const submit = (e: FormEvent) => {
    props.onSubmit(name)
    e.preventDefault()
  }
  return (
    <form autoComplete="off" onSubmit={submit} >
      <TextField required fullWidth id="name" label="Your Name" value={name} 
        onChange={(e) => {setName(e.target.value)}}
        inputProps={{pattern:'[\\s\\S]*\\S[\\s\\S]*'}}  />
      <Button variant="contained" color="primary" type="submit" className={classes.button}>Play!</Button>
    </form>  
  );
}

export default ScoreInput