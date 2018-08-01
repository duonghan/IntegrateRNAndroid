import React from 'react';
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import allReducers from './reducers/index';
import PlaceHolderContainer from "./containers/PlaceHolderContainer";

let store = createStore(allReducers);

export default class ButtonTemplate extends React.Component {
    render() {
        return (
            <Provider store={store}>
                <PlaceHolderContainer/>
            </Provider>
        );
    }
}