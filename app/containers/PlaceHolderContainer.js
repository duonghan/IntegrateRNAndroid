import PlaceHolder from '../components/PlaceHolder';

import {toggleButtonColor} from "../actions";
import {connect} from 'react-redux';

const mapStateToProps = () => {

};

const mapDispatchToProps = (dispatch) => {
    return {
        OnToggleColor: () => {
            dispatch(toggleButtonColor())
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(PlaceHolder);