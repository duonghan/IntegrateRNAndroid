import React from 'react';
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import allReducers from './reducers';
import PlaceHolderContainer from "./containers/PlaceHolderContainer";

let store = createStore(allReducers);

export default class ButtonTemplate extends React.Component {
    render() {
        <Provider store={store}>
            <PlaceHolderContainer/>
        </Provider>
    }
}