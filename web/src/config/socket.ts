import { receiveData, store } from '../store/store';

const socket = new WebSocket('ws://localhost:8080/socket');
socket.onopen = () => send('session-open', 'hello world');
socket.onmessage = (m) => {
  let parse;
  try {
    parse = JSON.parse(m.data);
  } catch (e) {
    parse = m.data;
  }
  return store.dispatch(receiveData(parse));
};

export const send = (command: string, payload: any) => {
  socket.send(JSON.stringify({ command, payload }));
};
