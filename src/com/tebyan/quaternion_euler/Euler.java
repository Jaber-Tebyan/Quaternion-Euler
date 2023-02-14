package com.tebyan.quaternion_euler;

public class Euler{
	public Euler(double yaw, double pitch, double roll) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
	}

	public Euler() {

	}

	double yaw,pitch,roll;

	@Override
	public String toString() {
		return "Euler [yaw=" + yaw + ", pitch=" + pitch + ", roll=" + roll + "]";
	}
	
}