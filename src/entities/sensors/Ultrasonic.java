package entities.sensors;

import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;

public class Ultrasonic extends AbstractFilter{

	private float[] sample;
	
	public Ultrasonic(SampleProvider source) {
		super(source);
		sample = new float[sampleSize];
	}
	
	public float getDistance() {
		super.fetchSample(sample, 0);
		return sample[0];
	}

}