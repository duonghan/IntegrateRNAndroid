import React, {Component} from 'react';
import {Button, Text, View} from 'react-native';
import { ReactMotion } from './ReactMotionDemo';

class HelloScreen extends Component{
    handleClick = () => {
        alert("Good job!!!");
    };

    render(){
        return(
            // <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#F5FCFF'}}>
            //     <Text style={{color: '#f74c59', textAlign: 'center', fontSize: 30 }}> Hello World</Text>
            //     <Button title='Click Here' onPress={this.handleClick}/>
            // </View>
            <View>
                <ReactMotion />
            </View>
        );
    }
}

export default HelloScreen;