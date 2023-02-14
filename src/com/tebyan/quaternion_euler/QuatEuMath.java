package com.tebyan.quaternion_euler;

public class QuatEuMath {

	/**
     * Constant by which to multiply an angular value in degrees to obtain an
     * angular value in radians.
     */
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295;

    /**
     * Constant by which to multiply an angular value in radians to obtain an
     * angular value in degrees.
     */
    private static final double RADIANS_TO_DEGREES = 57.29577951308232;
    
	public static Quaternion EulerToQuaternion(Euler euler) {
		Quaternion q=new Quaternion();
		// cos yaw , sin yaw , cos pitch , sin pitch , cos roll , sin roll
		double cy,sy,cp,sp,cr,sr;
		cy=Math.cos(euler.yaw*DEGREES_TO_RADIANS*.5);
		sy=Math.sin(euler.yaw*DEGREES_TO_RADIANS*.5);
		cp=Math.cos(euler.pitch*DEGREES_TO_RADIANS*.5);
		sp=Math.sin(euler.pitch*DEGREES_TO_RADIANS*.5);
		cr=Math.cos(euler.roll*DEGREES_TO_RADIANS*.5);
		sr=Math.sin(euler.roll*DEGREES_TO_RADIANS*.5);
		q.w=cy*cp*cr+sy*sp*sr;
		q.x=sy*cp*cr-cy*sp*sr;
		q.y=cy*sp*cr+sy*cp*sr;
		q.z=cy*cp*sr-sy*sp*cr;
		return q;
	}
	
//	e.yaw=Math.atan2(2*(q.w*q.z+q.x*q.y), 1-2*(q.z*q.z+q.y*q.y))*RADIANS_TO_DEGREES;
//	e.pitch=Math.asin(2*(q.w*q.y-q.x*q.z))*RADIANS_TO_DEGREES;
//	e.roll=Math.atan2(2*(q.w*q.x+q.y*q.z), 1-2*(q.x*q.x+q.y*q.y))*RADIANS_TO_DEGREES;
	
	public static Euler QuaternionToEuler(Quaternion q) {
		Euler e=new Euler();
		e.yaw=Math.atan2(2*(q.w*q.x+q.x*q.y), 1-2*(q.x*q.x+q.y*q.y))*RADIANS_TO_DEGREES;
		e.pitch=Math.asin(2*(q.w*q.y-q.x*q.z))*RADIANS_TO_DEGREES;
		e.roll=Math.atan2(2*(q.w*q.z+q.y*q.x), 1-2*(q.z*q.z+q.y*q.y))*RADIANS_TO_DEGREES;
		return e;
	}
//	e.yaw=Math.atan2(2*(q.w*q.x+q.z*q.y), 1-2*(q.x*q.x+q.y*q.y))*RADIANS_TO_DEGREES;
//	e.pitch=Math.asin(2*(q.w*q.y-q.x*q.z))*RADIANS_TO_DEGREES;
//	e.roll=Math.atan2(2*(q.w*q.z+q.y*q.x), 1-2*(q.z*q.z+q.y*q.y))*RADIANS_TO_DEGREES;
}
