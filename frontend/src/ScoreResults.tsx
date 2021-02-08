import React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

function ScoreResults(props: {data: Score[], latest: Score|false}) {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>#</TableCell>
            <TableCell>Name</TableCell>
            <TableCell align="right">Score</TableCell>
            <TableCell>Submitted</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {props.data.map((row, i) => (
            <TableRow key={row.id}>
              <TableCell component="th" scope="row">{i}</TableCell>
              <TableCell>{row.name}</TableCell>
              <TableCell align="right">{row.score}</TableCell>
              <TableCell>{row.time}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default ScoreResults