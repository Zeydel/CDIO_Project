import java.io.File;

import lejos.*;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
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
				
				
				hjul1.setPower(100);
				hjul2.setPower(100);
				skovl.setPower(100);
				
				
				hjul1.backward();
				hjul2.backward();
				skovl.backward();
				
				Delay.msDelay(3000);
				
				hjul1.stop();
				hjul2.stop();
				skovl.stop();
				
				baglås.setPower(100);
				baglås.backward();
				Delay.msDelay(1500);
				
				baglås.forward();
				Delay.msDelay(1000);

	}
}
