import PlaceHolder from '../components/PlaceHolder';

import {toggleButtonColor} from "../actions/index";
import {connect} from 'react-redux';

const mapStateToProps = (state) => {
    return {
        btnColor: state.toggleReducer.btnColor
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        onChangeColor: () => {
            dispatch(toggleButtonColor())
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(PlaceHolder);