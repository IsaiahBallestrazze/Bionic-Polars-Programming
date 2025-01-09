// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class vison extends SubsystemBase {

private PhotonCamera cam = new PhotonCamera("Cam");

private PhotonPipelineResult camread;
private PhotonTrackedTarget target;
private Transform3d distins;

private double x = 0.0;
private double y = 0.0;
private double yaw = 0.0;
private Rotation3d yawr ;
  /** Creates a new vison. */
  public vison() {

  }

// /* 

public boolean target(){
  camread = cam.getLatestResult();
camread.getTargets();
return camread.hasTargets();
}



public double camX(){
  camread = cam.getLatestResult();
camread.getTargets();

if (camread.hasTargets()){
  target=camread.getBestTarget();
distins=target.getBestCameraToTarget();
x= distins.getX();
return x;
}
  else{
    return 0;
  }
}

public double camY(){
  camread = cam.getLatestResult();
camread.getTargets();

if (camread.hasTargets()){
  target=camread.getBestTarget();
distins=target.getBestCameraToTarget();
y= distins.getY();
return y;
}
  else{
    return 0;
  }
}

public double camyaw(){
  camread = cam.getLatestResult();
camread.getTargets();

if (camread.hasTargets()){
  target=camread.getBestTarget();
distins=target.getBestCameraToTarget();
yawr=distins.getRotation();
yaw=yawr.getZ();
if(Math.toDegrees(yaw)>0){
  return 180- Math.toDegrees(yaw);
}
else{
  return -180 - Math.toDegrees(yaw);
}
}
  else{
    return 0;
  }
}



public double id(){
  camread = cam.getLatestResult();
camread.getTargets();

if (camread.hasTargets()){
  target=camread.getBestTarget();
  return target.getFiducialId();
}
else{
  return -1;
}
}

//*/







  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
