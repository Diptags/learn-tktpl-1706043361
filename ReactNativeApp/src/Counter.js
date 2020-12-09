import React from 'react';
import { Button, StyleSheet, Text } from 'react-native';
export default function Counter(props) {
  return (
    <>
    	<Text h1 style={styles.counter}>{props.counter}</Text>
      <Button
				onPress={props.handleOnClick}
				title='Click this Button'/>
    </>
  );
}

const styles = StyleSheet.create({
  counter: {
    margin: 10,
    fontSize: 30,
  },
});