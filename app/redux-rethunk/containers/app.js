import React, {Component} from 'react';
import {applyMiddleware, combineReducers, createStore} from 'redux';
import {Provider} from 'react-redux';
import thunk from 'redux-thunk';

import * as reducers from '../reducers/index';
import CounterApp from './counterApp';

const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);
const reducer = combineReducers(reducers);
const store = createStoreWithMiddleware(reducer);

export default class Counter extends Component {
    render() {
        return (
            <Provider store={store}>
                <CounterApp/>
            </Provider>
        );
    }
}
