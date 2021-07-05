import styled from '@emotion/styled';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { BoardPanel } from './modules/BoardPanel';
import { OptionPanel } from './modules/OptionPanel';
import { StatusPanel } from './modules/StatusPanel';
import { store } from './store';

const Canvas = styled.div`
  display: flex;
  height: 800px;
  justify-content: space-evenly;
  align-items: center;
  & > * {
    margin: 1rem;
  }
`;

ReactDOM.render(
  <Provider store={store}>
    <Canvas>
      <StatusPanel />
      <BoardPanel />
      <OptionPanel />
    </Canvas>
  </Provider>,
  document.getElementById('root')
);
