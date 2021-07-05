import styled from '@emotion/styled';

const Div = styled.div`
  flex-basis: 25%;
  height: inherit;
  border: 1px solid black;
  .title {
    text-align: center;
  }
`;
export const OptionPanel = () => {
  return (
    <Div>
      <h1 className="title">多人在线游戏模板</h1>
    </Div>
  );
};
