import React, {Component} from 'react';
import {Button, Text, View} from 'react-native';

class PlaceHolder extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const {btnColor, onChangeColor} = this.props;

        return (
            <View style={{flex: 1, alignItems: 'center', justifyContent: 'center'}}>
                <Text style={{color: btnColor}}>{btnColor}</Text>
                <Button title='Change button bg color' onPress={onChangeColor}
                        color={btnColor}/>
            </View>
        )
    }
}

export default PlaceHolder;