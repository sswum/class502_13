import React, { Suspense, useState } from "react";
import { Link, Navigate } from "react-router-dom";
import styled from "styled-components";
import loadable from "@loadable/component";

//const MessageBox=React.lazy(() => import("../components/commons/MessageBox"));

//const MessageBox2 = styled(MessageBox)`
//background: orange;
//`;

const MessageBox = loadable(() => import("../components/commons/MessageBox"), {
    fallback : <div>로딩중...</div>
});



const Home = () => {
  const [visible, setvisible] = useState(false);
  /*  const result = true;
    if(result) {
        return <Navigate to="/about" replace={true} />;
    } */

  return (
    <div>
      <h1>HOME</h1>
      <div>메인 페이지</div>
      <div>
        <Link to="/about">회사 소개</Link>
        {/* <Suspense fallback={<div>로딩중....</div>}> 
                    {visible && <MessageBox> 메세지 !! </MessageBox>}
                 </Suspense> */}

        {visible && <MessageBox>메세지!!!</MessageBox>}

        <button type="button" onClick={() => setvisible(true)}>
          보이기
        </button>
      </div>
      {/* <MessageBox>메세지!!!</MessageBox> */}
    </div>
  );
};

export default React.memo(Home);

//export default React.memo(Home); 성능상 좋기때문에 memo() 감싸주기
