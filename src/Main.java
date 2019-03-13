import java.io.File;

import lejos.*;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;
import lejos.utility.Delay;

public class Main {


	public static void main(String[] args) {
		
		
				/*
				for(int i = 0; i < 3; i++) {
					Sound.playTone(500, 800);
					Delay.msDelay(200);
				}
				*/

				Sound.playTone(1000, 800);
				
				

				//EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S1);
				//EV3UltrasonicSensor uss = new EV3UltrasonicSensor(SensorPort.S2);

				
				/*
				EV3LargeRegulatedMotor hjul1 = new EV3LargeRegulatedMotor(MotorPort.B);
				EV3LargeRegulatedMotor hjul2 = new EV3LargeRegulatedMotor(MotorPort.C);
				
				EV3MediumRegulatedMotor baglås = new EV3MediumRegulatedMotor(MotorPort.A);
				EV3MediumRegulatedMotor skovl = new EV3MediumRegulatedMotor(MotorPort.D);
				
			*/
				
				UnregulatedMotor hjul1 = new UnregulatedMotor(MotorPort.B);
				UnregulatedMotor hjul2 = new UnregulatedMotor(MotorPort.C);
				
				UnregulatedMotor baglås = new UnregulatedMotor(MotorPort.A);
				UnregulatedMotor skovl = new UnregulatedMotor(MotorPort.D);
				
				EV3UltrasonicSensor usensor = new EV3UltrasonicSensor(SensorPort.S3);
				Ultrasonic ultrasonic = new Ultrasonic(usensor.getMode("Distance"));
				
				
				hjul1.setPower(100);
				hjul2.setPower(100);
				skovl.setPower(100);
				
				
				hjul1.backward();
				hjul2.backward();
				skovl.backward();
				
				boolean driving = true;
				int counter = 0;
				
				while(driving) {
					
					float distance = ultrasonic.distance();
					
					if(distance < 0.2) {
						hjul1.stop();
						hjul2.stop();
						counter++;
						
						hjul1.backward();
						Delay.msDelay(350);
						hjul1.stop();
						
						if(counter == 4) {
							driving = false;
							baglås.setPower(100);
							baglås.backward();
							Delay.msDelay(1500);
							
							baglås.forward();
							Delay.msDelay(1000);
						}
						else {
							hjul1.backward();
							hjul2.backward();
						}
						
						
					}
					
				}

	}
	
}

class Ultrasonic extends AbstractFilter{

	float[] sample;
	
	public Ultrasonic(SampleProvider source) {
		super(source);
		sample = new float[sampleSize];
	}
	
	public float distance() {
		super.fetchSample(sample, 0);
		return sample[0];
	}
	
}
