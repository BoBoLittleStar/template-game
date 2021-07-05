import styled from '@emotion/styled';
import { useEffect, useRef } from 'react';
import { useSelector } from 'react-redux';
import { Button, Title } from '../../../components';
import { TypeState } from '../../../store/store';

export const ChatPanel = () => {
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    inputRef.current?.focus();
  }, []);

  const textHistory = useSelector((state: TypeState) => state.textHistory);
  const Div = styled.div`
    flex-grow: 1;
    border: 1px solid black;
    display: flex;
    flex-direction: column;
    .text-area {
      flex-grow: 1;
      border: 1px solid black;
    }
    span {
      display: flex;
      input {
        flex-grow: 1;
      }
    }
  `;
  return (
    <Div>
      <Title>聊天室</Title>
      <div className="text-area">
        {textHistory?.map((text) => (
          <div>{text}</div>
        ))}
      </div>
      <span>
        <input ref={inputRef} />
        <Button>发送</Button>
      </span>
    </Div>
  );
};
