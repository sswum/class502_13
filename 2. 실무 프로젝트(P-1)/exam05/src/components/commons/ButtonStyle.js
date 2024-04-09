import styled, { css } from "styled-components";

export const BigButton = styled.button`
  width: 100%;
  height: 45px;
  border: 0;
  background: ${({ bgcolor }) => bgcolor ?? "orange"};
  font-size: 1.5rem;
  font-weight: bold;

${({selected, bgcolor})=> selected && css `
border : 1px solid  ${bgcolor ?? 'orange' };
background: #fff;

`}

`;

//styled.button 속성값이 props에 들어감! 그래서 그 속성값을 적용
// bgcolor ?? 'orange' 파랑색 안 나오면 오렌지 나오게 해줭~
