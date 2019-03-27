package controllers.impl;

import controllers.interfaces.IMovementController;
import entities.sensors.Gyro;
import entities.sensors.Ultrasonic;
import lejos.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

public class MovementController implements IMovementController{
	
	private UnregulatedMotor wheel1, wheel2, trunk, collector;
	private EV3UltrasonicSensor usensor;
	private Ultrasonic ultrasonic;
	private EV3GyroSensor gsensor;
	private Gyro gyro;
	

	public MovementController(){
		wheel1 = new UnregulatedMotor(MotorPort.B);
		wheel2 = new UnregulatedMotor(MotorPort.C);
		
		trunk = new UnregulatedMotor(MotorPort.A);
		collector = new UnregulatedMotor(MotorPort.D);
		
		/*
		usensor = new EV3UltrasonicSensor(SensorPort.S3);
		ultrasonic = new Ultrasonic(usensor.getMode("Distance"));
		
		gsensor = new EV3GyroSensor(SensorPort.S2);
		gyro = new Gyro(gsensor.getMode("Angle"));
		*/
		
		wheel1.setPower(100);
		wheel2.setPower(100);
		collector.setPower(100);
		trunk.setPower(100);
	}
	
	public void driveCar(int time) {
		motorOn("left");
		motorOn("right");
		
		if(time != 0) {
			Delay.msDelay(time);
		}
		
	}
	
	public void stopCar() {
		motorOff("left");
		motorOff("right");
	}
	
	public void motorOn(String motor) {
		
		motor.toLowerCase();
		
		switch(motor) {
		case "left": 
			wheel1.backward();
			break;
			
		case "right":
			wheel2.backward();
			break;
		}
	}
	
	public void motorOff(String motor) {
		motor.toLowerCase();
		
		switch(motor) {
		case "left": 
			wheel1.stop();
			break;
			
		case "right":
			wheel2.stop();
			break;
		}
	}
	
	public void frontCollectorOn() {
		collector.backward();
	}
	
	public void frontCollectorOff() {
		collector.stop();
	}
	
	public void openTrunk() {
		trunk.backward();
		Delay.msDelay(1000);
	}
	
	public void closeTrunk() {
		trunk.forward();
		Delay.msDelay(1000);
	}
	
	public void turnRight(boolean continueDriving) {
		wheel2.stop();
		wheel1.stop();
		
		wheel2.backward();
		
		Delay.msDelay(1000);
		
		wheel1.stop();
		
		if(continueDriving) {
			wheel1.backward();
			wheel2.backward();
		}
	}
	
	public void turnLeft(boolean continueDriving) {
		wheel2.stop();
		wheel1.stop();
		
		wheel1.backward();
		
		Delay.msDelay(1000);
		
		wheel1.stop();
		
		if(continueDriving) {
			wheel1.backward();
			wheel2.backward();
		}
	}
}
