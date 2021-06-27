const socket = new WebSocket('ws://localhost:8080/socket');
socket.onopen = () => send('open', 'hello world');

export const send = (command: string, payload: any) => {
  socket.send(JSON.stringify({ command, payload }));
};
