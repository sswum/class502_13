import styles from "./CSSModule.module.scss";
import { useState } from "react";
import classNames from "classnames/bind";

const cx = classNames.bind(styles);
//bind는 새로운 매개 변수를 만들어냄

const CSSModule = () => {
  const [visible, setVisible] = useState(false);

  return (
    <>
      <div className={styles.wrapper}>
        <span className="commonColor"></span> 안녕하세요,
        <span className={styles.highlight}>반갑습니다.</span>
      </div>
      <div className={cx('menus', ["cls1", "cls2"], { on: visible })}>
        메뉴
      </div>
      <button type="button" onClick={() => setVisible(!visible)}>
        클릭
      </button>
    </>
  );
};

export default CSSModule;
