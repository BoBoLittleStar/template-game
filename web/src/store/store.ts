import { configureStore, createAction, createReducer } from '@reduxjs/toolkit';

export const receiveData = createAction('receiveData', (data: string) => {
  return { payload: data };
});

const reducer = createReducer<string | undefined>(undefined, builder => {
  builder.addCase(receiveData, (state, action) => {
    return action.payload;
  });
});

export const store = configureStore({
  reducer,
});
