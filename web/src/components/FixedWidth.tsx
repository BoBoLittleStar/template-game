import styled from '@emotion/styled';

type props = {
  maxChars: number;
};

export const FixedWidth: React.FC<props> = ({ maxChars, children }) => {
  const Span = styled.span`
    flex-basis: ${maxChars}em;
    white-space: nowrap;
    overflow: hidden;
  `;

  return <Span>{children}</Span>;
};
