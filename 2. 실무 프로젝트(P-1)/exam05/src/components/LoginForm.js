import { BigButton } from './commons/ButtonStyle';

import styled, { css } from "styled-components"; //styled는 뭔가 형식적으로 많이 쓰는 이름
//styled는 태그함수를 사용해서 한다, 역따옴표 사용

//밑에 ${commonStyle} 사용해서 변수 적용 커몬스타일은 변수라 소문자시작임
const commonStyle = css `
width: 100%; 
`
;
const OuterBox = styled.div `
${commonStyle}
position : fixed;
height: 100%;
left: 0;
top: 0;
display: flex;
align-items: center;
`;

const FormBox = styled.form`
width:420px;
margin: 0 auto;

h1 {
    text-align: center;
}

`;

const InputBox = styled.input`
  display: block;
  height: 45px;
  width: 100%;
  border: 1px solid #ccc;
  boder-radius: 5px;
  padding: 0 10px;

// & + & 인접형제결합자로 + 지정한 요소의 바로 다음에 위치함
 
  & + & {
    margin-top: 5px;
  }
`;



const LoginForm = () => {
  return (
      
      <OuterBox> 
      <FormBox autoComplete="off">
      <h1>로그인</h1>
        <InputBox type="text" placeholder="아이디" />
        {/* 위에 인풋박스를 바로 적용하면 스타일이 적용됨 원래는 button이였음 */}
        <InputBox type="password" placeholder="비밀번호" />

        <BigButton type="submit" selected={true} >로그인
        </BigButton>
      
      </FormBox>
      </OuterBox>
    
  );
};

export default LoginForm;


// <> </> 프레그먼트 , <아우터박스로 감싸기>