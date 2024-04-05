import { useState } from 'react';
import { MdOutlineCheckBox, MdCheckBoxOutlineBlank } from "react-icons/md";

const initialValue = [
  { id: 1, title: '할일1', done: false },
  { id: 2, title: '할일2', done: true },
  { id: 3, title: '할일3', done: false },
];

const Todos = () => {
  const [items , setItems] = useState(initialValue);
  const onToggle = (id) => {
    const newItems = items.map(item =>item.id ===id ? {...item, done:!item.done} : item)

    setItems(newItems);
  };
  //   const listItems = items.map((item) => <li>{item.title}</li>);
  return (
    <ul>
      {items.map(({ id, title , done}) => (
        <li key={id} onClick={()=> ontoggle(id)}>
            { done ? <MdOutlineCheckBox /> : <MdCheckBoxOutlineBlank/> }
            {title}
            </li>
      ))}
    </ul>
  );
};

export default Todos;
