const apiRoot = process.env.REACT_APP_BACKEND_ROOT

async function getAll(): Promise<Score[]> {
  return fetch(apiRoot + '/score')
    .then(response => response.json())
}

async function submit(data: ScoreInput): Promise<Score> {
  return fetch(apiRoot + '/score', {
    method: 'POST', 
    body: JSON.stringify(data), 
    headers: {
      'Content-Type': 'application/json',
    }})
  .then(response => response.json())
}

export {getAll, submit};