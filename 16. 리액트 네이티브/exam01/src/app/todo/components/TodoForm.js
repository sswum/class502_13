import React from "react";
import {
  IoMdRadioButtonOff,
  IoIosRadioButtonOn,
  IoMdRadioButtonOn,
} from "react-icons/io";

const TodoForm = ({ onSubmit, onChange }) => {
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <dl>
        <dt>할일</dt>
        <dd>
          <input type="text" name="title" onChange={onChange} />
        </dd>
      </dl>
      <dl>
        <dt>내용</dt>
        <textarea name="content" onChage={onChange} />
      </dl>
      <dl>
        <dt>완료여부</dt>
        
        <dd>
          <span>
            <IoMdRadioButtonOff />
            미완료
          </span>
          <span>
            <IoMdRadioButtonOn />
            완료
          </span>
        </dd>
      </dl>
      <button type="submit">할일 등록</button>
    </form>
  );
};

export default TodoForm;
