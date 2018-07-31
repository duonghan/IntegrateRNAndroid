import {TOGGLE_BUTTON_COLOR} from "../actions/actionTypes";

const initialState = {btnColor: 'red'};

const toggleReducer = (state = initialState, action) => {

    if (action.type === TOGGLE_BUTTON_COLOR) {
        return {
            ...state,
            btnColor: state.btnColor === 'red' ? 'green' : 'red'
        }
    }

    return state;
};

export default toggleReducer;

