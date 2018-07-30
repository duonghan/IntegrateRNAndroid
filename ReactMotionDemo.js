import React, { Component } from 'react';
import _ from 'lodash';
import { presets, spring, StaggeredMotion, Motion } from 'react-motion';
import { Dimensions, PanResponder, View, Image , Animated} from 'react-native';

const {height: screenHeight, width: screenWidth} = Dimensions.get('window');
const colors = ['#F44336', '#9C27B0', '#2196F3', '#009688', '#FF9800', '#607D8B'];

export class ReactMotion extends Component{
    state = {
        x: 0,
        y: 0,
        isShow: true,
        dropAreaValues: {},
        isReleaseBubbles: false,
        pan: new Animated.ValueXY(),
        opacity: new Animated.Value(1),
    }

    panResponder = PanResponder.create({
        onMoveShouldSetPanResponderCapture: () => true,
        onPanResponderMove: (event) => {
            this.setState({x: event.nativeEvent.pageX, y: event.nativeEvent.pageY, isReleaseBubbles : true})
        },

        onPanResponderRelease: (e, gesture) => {

            // if (this.isDropArea(gesture)) {
            //     Animated.timing(this.state.opacity, {
            //             toValue: 0,
            //             duration: 1000
            //         }).start(() =>
            //         this.setState({
            //             showDraggable: false
            //         })
            //     );
            // } else {
            //     Animated.spring(this.state.pan, {
            //         toValue: { x: 0, y: 0 },
            //         friction: 5,
            //     }).start();
            // }

            debugger;
            this.setState({isReleaseBubbles : false});

            if(this.state.x > screenWidth/2){
                this.setState({x: screenWidth - 50})
            }else{
                this.setState({x: 0})
            }

            if(this.state.y > screenHeight){
                this.setState({y: screenHeight - 100})
            }
        }
    })

    isDropArea(gesture) {
        return gesture.moveY < 200;
    }

    applyCoordinate = (coordinate) => {
        let x = coordinate.x > screenWidth ? screenWidth - 100 : coordinate.x;
        let y = coordinate.y > screenHeight ? screenHeight - 100 : coordinate.y;
        return {x,y};
    }

    doEdgePosition(i, prevStyle){
        i === 0 ? this.state : {
            x: spring(prevStyle.x, presets.gentle),
            y: spring(prevStyle.y, presets.gentle),
        }
    }

    render () {
        return <View {...this.panResponder.panHandlers}
                     style={{width: screenWidth, height: screenHeight}}>

                    <Motion
                        defaultStyle={{x: 0, y: 0}}
                        style = { this.state.isReleaseBubbles ?  {x: spring(this.state.x/10, presets.gentle),y: spring(this.state.y/13, presets.gentle)} :
                        {x: spring(this.state.x/13, presets.gentle),y: spring(100, presets.gentle)}}>

                        {
                            value =>
                            <View style={{position: 'absolute', height:150, bottom: 0, left: 0, right: 0, justifyContent: 'center', alignItems: 'center'}} >
                                <Image
                                        style = {{
                                            left: value.x,
                                            top: value.y,
                                        }}
                                       source={require('./delete.png')}
                                />
                            </View>
                        }

                    </Motion>

                    <StaggeredMotion
                        defaultStyles={_.range(6).map(() => ({x: 0, y: 0}))}

                        styles={(prevStyles) => prevStyles.map((a, i) => {
                             return i === 0 ? this.state : {
                                 x: spring(prevStyles[i-1].x, presets.gentle),
                                 y: spring(prevStyles[i-1].y, presets.gentle),
                             }
                         })}
                    >

                        {styles =>
                            <View>
                                {styles.slice().reverse().map(({x, y}, i) => {
                                    const index = styles.length - i - 1
                                    return <View key={index}
                                         style={{
                                             width: 70,
                                             borderRadius: 35,
                                             height: 70,
                                             position: 'absolute',
                                             left: x + 2 * index,
                                             top: y + 2 * index,
                                             backgroundColor: colors[index],
                                         }}/>
                                    }
                                )}
                            </View>
                        }
                    </StaggeredMotion>

                </View>
    };


}
