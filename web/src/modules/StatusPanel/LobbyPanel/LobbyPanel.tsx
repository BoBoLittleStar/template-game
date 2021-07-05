import styled from '@emotion/styled';
import { useSelector } from 'react-redux';
import { Button, Row, Title } from '../../../components';
import { TypeState } from '../../../store';

export const LobbyPanel = () => {
  const Div = styled.div`
    flex-grow: 1;
    border: 1px solid black;
    display: flex;
    flex-direction: column;
  `;

  const totalPlayers = useSelector((state: TypeState) => state.totalPlayers);
  return (
    <Div>
      <Title>游戏大厅</Title>
      <Row>当前在线人数：{totalPlayers}</Row>
      <Row>
        <Button>开始游戏</Button>
      </Row>
    </Div>
  );
};
