import React from 'react';
import Buttons from './components/Buttons2';


function App() {
  const name = '기미름';
  return (
    <>
      {name && <h1>안녕하세요 ! , {name}</h1>}
      <h2>리액트수업중입니다.</h2>
      <Buttons color="orange">확인????</Buttons>
    </>
  );
}
export default App;
