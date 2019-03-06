import java.io.File;

import lejos.*;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.robotics.filter.AbstractFilter;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.*;

public class Main {
	
	public static void main(String[] args) {
		
		//UltrasonicDistance();
		
		Button.waitForAnyPress();
		for(int i = 0; i < 3; i++) {
			Sound.playTone(500, 800);
			Delay.msDelay(200);
		}

		Sound.playTone(1000, 800);

		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S1);
		EV3UltrasonicSensor uss = new EV3UltrasonicSensor(SensorPort.S2);

		UnregulatedMotor b = new UnregulatedMotor(MotorPort.B);
		UnregulatedMotor c = new UnregulatedMotor(MotorPort.C);
		
		while(true) {
			
			ColorSensor(b,c, cs);
			
		}
	}
	
	/*
	public static void UltrasonicDistance() {
		DifferentialPilot pilot = new DifferentialPilot(1.5f, 6, Motor.B, Motor.C);
		Brick b = BrickFinder.getDefault();
		Port s2 = b.getPort("S2");
		EV3UltrasonicSensor us = new EV3UltrasonicSensor(s2);
		Ultrasonic ultrasonic = new Ultrasonic(us.getMode("Distance"));
		
		while(true) {
			Delay.msDelay(2);
			
			float distance = ultrasonic.distance();
			if(distance < 0.3) {
				pilot.forward();
			}
			else if(distance > 1) {
				pilot.backward();
			}
			else {
				pilot.stop();
			}
			
			if(Button.ESCAPE.isDown()) {
				pilot.stop();
				us.close();
				System.exit(0);
			}
		}
	}

	*/
		
		public static void ColorSensor(UnregulatedMotor b, UnregulatedMotor c, EV3ColorSensor cs) {
			if(cs.getColorID() == 2) {
				b.setPower(100);
				c.setPower(100);

				b.backward();
				c.backward();

				Delay.msDelay(5000);

			}
		
	}
	
}




