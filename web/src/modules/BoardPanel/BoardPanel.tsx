import styled from '@emotion/styled';
import { Template } from './Template';

const width = 400;
const height = 400;

const Div = styled.div`
  border: 3px solid black;
  aspect-ratio: ${width / height};
  height: inherit;
  svg {
    .title {
      transform: translateX(-1rem) translateY(1rem);
    }
    .tip {
      transform: translateX(-5rem) translateY(1rem);
    }
    .diag {
      stroke: lightgray;
      stroke-width: 1;
      stroke-dasharray: 1 2;
    }
  }
`;

export const BoardPanel = () => {
  return (
    <Div>
      <svg viewBox={`-${width / 2} -${height / 2} ${width} ${height}`}>
        <Template />
      </svg>
    </Div>
  );
};
