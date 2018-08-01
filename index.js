/** @format */

import {AppRegistry} from 'react-native';
import App from './App';
import HelloScreen from './HelloWorld';
import ButtonTemplate from "./app/redux/index";
import Counter from "./app/redux-rethunk/containers/app";
import AsyncStorageExample from "./app/async/AsyncStorageExample";
import ReduxSagaScreen from "./app/redux-saga";

AppRegistry.registerComponent('TestConvert', () => App);
AppRegistry.registerComponent('HelloScreen', () => HelloScreen);
AppRegistry.registerComponent('ButtonScreen', () => ButtonTemplate);
AppRegistry.registerComponent('CounterScreen', () => Counter);
AppRegistry.registerComponent('AsyncStorageScreen', () => AsyncStorageExample);
AppRegistry.registerComponent('ReduxSagaScreen', () => ReduxSagaScreen);
