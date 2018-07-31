import {combineReducers} from 'redux';
import toggleReducer from './toggleReducer';

const allReducers = combineReducers({
    toggleReducer,
});

export default allReducers;
