import { Typography } from '@material-ui/core';
import React from 'react'

function YourScore(props: {score: Score|false}) {
  return (
    <Typography variant="h4" component="div" align="center">
      {props.score!==false? (props.score.score>0 ? "Congratulations!" : "Bummer!") + " You scored " + props.score.score : ''}
    </Typography>
  );
}

export default YourScore