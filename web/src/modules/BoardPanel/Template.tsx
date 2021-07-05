export const Template = () => {
  return (
    <>
      <text y={-100} className="title">
        画布
      </text>
      <line className="diag" x1="-100%" y1="-100%" x2="100%" y2="100%" />
      <line className="diag" x1="-100%" y1="100%" x2="100%" y2="-100%" />
      <text className="tip">默认原点位于画布正中</text>
      <circle r={1} fill="red" />
    </>
  );
};
