import { useSelector } from 'react-redux';
import { send } from './config/socket';

export const App = () => {
  const str = useSelector(state => state);
  return <div>
    <button onClick={() => send('template', { a: 1, b: 2 })}>Click me</button>
    <div>{str}</div>
  </div>;
};
