import PlaceHolder from '../components/PlaceHolder';

import {toggleButtonColor} from "../actions";
import {connect} from 'react-redux';

const mapStateToProps = (state) => {
    btnColor: state.btnColor
};

const mapDispatchToProps = (dispatch) => {
    return {
        onChangeColor: () => {
            dispatch(toggleButtonColor())
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(PlaceHolder);