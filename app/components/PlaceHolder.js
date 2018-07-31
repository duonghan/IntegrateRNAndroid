import React, {Component} from 'react';
import {Button, Text, View} from 'react-native';

class PlaceHolder extends Component {
    onChangeColor = () => {
        // this.setState((prevState) => {
        //     return {
        //         color: !prevState.color,
        //         text: `You've already clicked this button`
        //     }
        // })
        this.prop.OnToggleColor();
    };

    constructor(props) {
        super(props);
        this.state = {
            color: true,
            text: 'Hi!! buddy'
        }
    }

    render() {
        return (
            <View>
                <Text style={{color: 'red'}}>{this.state.text}{'\n\n'}</Text>
                <Button title='Change button bg color' onPress={this.onChangeColor}
                        color={this.state.color ? 'red' : 'green'}/>
            </View>
        )
    }
}

export default PlaceHolder;