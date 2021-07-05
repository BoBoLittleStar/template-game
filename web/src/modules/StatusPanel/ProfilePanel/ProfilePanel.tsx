import styled from '@emotion/styled';
import { Button, FixedWidth, Title, Row, Glue } from '../../../components';
import { useCallback, useState } from 'react';

import { name, random, storeName } from '../../../config/name';
import { RequestCommand } from '../../../store/request';

const Div = styled.div`
  flex-basis: 40%;
  border: 1px solid black;
`;
export const ProfilePanel = () => {
  const [currentName, setCurrentName] = useState(name);

  const handleRename = useCallback(() => {
    const str = prompt(
      '输入一个新名字（最长显示 8 个汉字）',
      currentName
    )?.trim();
    if (str) {
      RequestCommand.sendRename(str);
      setCurrentName(str);
      storeName(str);
    }
  }, [currentName]);

  const handleRandom = useCallback(() => {
    const str = random();
    RequestCommand.sendRename(str);
    setCurrentName(str);
    storeName(str);
  }, []);

  return (
    <Div>
      <Title className="title">个人信息</Title>
      <Row>
        名称：<FixedWidth maxChars={8}>{currentName}</FixedWidth>
        <Button onClick={handleRename}>改名</Button>
        <Glue />
        <Button onClick={handleRandom}>随机</Button>
        <Glue />
      </Row>
    </Div>
  );
};
