import styled from '@emotion/styled';
import { useSelector } from 'react-redux';
import { TypeState } from '../../store';
import { ChatPanel } from './ChatPanel';
import { LobbyPanel } from './LobbyPanel';
import { ProfilePanel } from './ProfilePanel';

const Div = styled.div`
  flex-basis: 25%;
  display: flex;
  height: inherit;
  flex-direction: column;
`;
export const StatusPanel = () => {
  const currentGame = useSelector((state: TypeState) => state.currentGame);
  return (
    <>
      <Div>
        <ProfilePanel />
        {currentGame ? <ChatPanel /> : <LobbyPanel />}
      </Div>
    </>
  );
};
