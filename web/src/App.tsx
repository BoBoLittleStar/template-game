import { send } from './config/socket';

export const App = () => {
  return <div>
    <button onClick={() => send('app', { a: 1, b: 2 })}>Click me</button>
  </div>;
};
