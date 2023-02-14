package com.tebyan.quaternion_euler;

public class Quaternion {
	double w,x,y,z;

	public Quaternion() {
	}

	public Quaternion(Euler euler) {
		Quaternion quaternion=QuatEuMath.EulerToQuaternion(euler);
		this.w = quaternion.w;
		this.x = quaternion.x;
		this.y = quaternion.y;
		this.z = quaternion.z;
	}
	public Quaternion(double w, double x, double y, double z) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Quaternion [w=" + w + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	
}