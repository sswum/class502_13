import React, { Component } from 'react';
import PropTypes from 'prop-types';

class Buttons2 extends Component {
  render() {
    const {color ,children} = this.props;

    //console.log('props' , Object.getOwnPropertyDescriptor(this.props));
    //console.log("props", Object.isFrozen(this.props));

    const styles = {
      background: color ?? 'black',
    };

    return <button color={PropTypes}>확인하기</button>;
  }
}

/*
Buttons2.defaultProps = {
  color: 'black',
};
*/

Buttons2.propTypes = {
color : PropTypes.string.isRequired, //문자열, 필수 항목
};
export default Buttons2;
