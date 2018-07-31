/** @format */

import {AppRegistry} from 'react-native';
import App from './App';
import HelloScreen from './HelloWorld';
import ButtonTemplate from "./app";
import Counter from "./appNew/containers/app";

AppRegistry.registerComponent('TestConvert', () => App);
AppRegistry.registerComponent('HelloScreen', () => HelloScreen);
AppRegistry.registerComponent('ButtonScreen', () => ButtonTemplate);
AppRegistry.registerComponent('CounterScreen', () => Counter);
