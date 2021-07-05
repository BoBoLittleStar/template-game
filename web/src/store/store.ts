import {
  configureStore,
  createAction,
  createReducer,
  PayloadActionCreator,
} from '@reduxjs/toolkit';
import { ResponseCommand } from './response';

export type TypeState = {
  totalPlayers: number;
  gameModes?: string[];
  currentGame?: any;
  matchedOpponent?: string[];
  textHistory?: string[];
};

const initialState: TypeState = {
  totalPlayers: 0,
};

const reducers: {
  [p in ResponseCommand]: (state: TypeState, payload: any) => TypeState;
} = {
  [ResponseCommand.receiveChatMessage]: (state, payload) => ({
    ...state,
    textHistory: state.textHistory
      ? [...state.textHistory, payload]
      : [payload],
  }),
  [ResponseCommand.receiveCurrentGame]: (state, payload) => ({
    ...state,
    currentGame: JSON.parse(payload),
  }),
  [ResponseCommand.receiveGameModes]: (state, payload) => ({
    ...state,
    gameModes: JSON.parse(payload),
  }),
  [ResponseCommand.receiveMatchedOpponents]: (state, payload) => ({
    ...state,
    matchedOpponents: JSON.parse(payload),
  }),
  [ResponseCommand.receiveTotalPlayers]: (state, payload) => ({
    ...state,
    totalPlayers: payload,
  }),
};

const actions = Object.values(ResponseCommand).reduce((map, command) => {
  map[command] = createAction(command, (payload) => ({ payload }));
  return map;
}, {} as { [p in ResponseCommand]: PayloadActionCreator<any> });

const reducer = createReducer<TypeState>(initialState, (builder) => {
  Object.values(ResponseCommand).forEach((command) => {
    builder.addCase(actions[command], (state, { payload }) =>
      reducers[command](state, payload)
    );
  });
});

export const store = configureStore({ reducer });

const dispatch = (command: ResponseCommand, payload: any) => {
  store.dispatch(actions[command](payload));
};

export default dispatch;
