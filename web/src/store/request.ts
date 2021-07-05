import { id, name } from '../config';
import { receive } from '../store';

const socket = new WebSocket('ws://localhost:8080/socket');

const send = (command: string, payload?: Record<string, unknown>) => {
  socket.send(JSON.stringify({ command, payload }));
};

export const RequestCommand = {
  sendSessionOpen: () => send('session-open', { id, name }),
  sendRename: (name: string) => send('rename', { name }),
  sendFindMatch: (mode: string) => send('find-match', { mode }),
  sendMessage: (message: string) => send('chat-message', { message }),
};

socket.onopen = RequestCommand.sendSessionOpen;
socket.onmessage = receive;
