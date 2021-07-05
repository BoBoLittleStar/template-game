import dispatch from './store';

export enum ResponseCommand {
  receiveTotalPlayers = 'total-players',
  receiveGameModes = 'game-modes',
  receiveCurrentGame = 'current-game',
  receiveChatMessage = 'chat-message',
  receiveMatchedOpponents = 'matched-opponents',
}

const reducer: { [p in ResponseCommand]: (payload: any) => any } = {
  [ResponseCommand.receiveTotalPlayers]: (payload) => payload.totalPlayers,
  [ResponseCommand.receiveGameModes]: (payload) => payload.gameModes,
  [ResponseCommand.receiveCurrentGame]: (payload) => payload.currentGame,
  [ResponseCommand.receiveChatMessage]: (payload) => payload.message,
  [ResponseCommand.receiveMatchedOpponents]: (payload) => payload.opponents,
};

type Response = {
  command: ResponseCommand;
  payload: any;
};

export const receive = ({ data }: { data: string }) => {
  const parse = JSON.parse(data) as Response;
  dispatch(parse.command, reducer[parse.command](parse.payload));
};
