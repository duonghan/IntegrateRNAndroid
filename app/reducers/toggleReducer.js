import {TOGGLE_BUTTON_COLOR} from "../actions/actionTypes";

const toggleReducer = (initalState = {isToggle: true}, action) => {
    if (action.type === TOGGLE_BUTTON_COLOR) {
        return {
            isToggle: !isToggle
        }
    } else {
        return initalState;
    }
};

export default toggleReducer;

