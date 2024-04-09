import React from "react";

const MessageBox = ({ className, children }) => {

    return
    <div className={className}> {children} </div>;
    
    
};

export default React.memo(MessageBox);

//memozation기능을 계속 쓸 수 있도록 자주 쓰는게 좋음
