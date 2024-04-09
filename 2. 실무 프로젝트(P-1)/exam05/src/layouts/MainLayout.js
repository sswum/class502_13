import React from "react";
import { Outlet, NavLink } from "react-router-dom";
import classNames from "classnames";

const MainLayout = () => {
  return (
    <>
      <header>
        <h1> 헤더 영역 </h1>
        <div>
          <NavLink
            to="/about"
            className={({ isActive }) => classNames("menu", { on: isActive })}
          >
            {" "}
            ABout
          </NavLink>
          <NavLink
            to="/board"
            className={({ isActive }) => classNames("menu", { on: isActive })}
          >
            {" "}
            BOARD
          </NavLink>
        </div>
      </header>
      <main>
        <Outlet />
      </main>
      <footer>
        <h1> 푸터 영역</h1>
      </footer>
    </>
  );
};

export default React.memo(MainLayout);

//헤더랑 푸터는 고정돼서 화면이 나오고 그안에 아울렛이 중첩라우터 돼서 보임
