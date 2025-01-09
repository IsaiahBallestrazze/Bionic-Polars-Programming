// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.vison;

public class falow extends Command {
  private final drive s_drive;
  private final vison s_vison;

private final Supplier <Boolean> button;
private final double ofset=1;
 // private final double hight=1.22;

private double angal;
private double posishon;
private double distens;
private double speed;
private double turn;


  /** Creates a new swervedrive. */
  public falow(drive d_drive, vison d_vison, Supplier<Boolean> d_axes3) {

s_drive=d_drive;
s_vison=d_vison;
button=d_axes3;


addRequirements(s_drive,s_vison);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_drive.swerve(222, 0, 0, 222);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
if(s_vison.id()==0||s_vison.id()==6||s_vison.id()==5){


angal=Math.toDegrees(Math.tanh(Math.abs(s_vison.camY())/s_vison.camX()));

posishon=s_vison.camX()-ofset;


distens=(Math.abs(posishon))/(Math.cos(angal));

SmartDashboard.putNumber("angal",angal);
SmartDashboard.putNumber("distens", distens);


if(s_vison.camY()<=0&&posishon>=.1){
angal=180-angal;
}
else if(s_vison.camY()>0&&posishon>=.1){
angal=-(180-angal);
}
else if(s_vison.camY()<=0&&posishon<-.2){

}
else if(s_vison.camY()>0&&posishon<-.2){
angal=-angal;
}
else{
  angal=222;
}

SmartDashboard.putNumber("test", angal);


if(posishon>.1){
speed=.15/s_drive.slow();//.4 defalt
}
else if(posishon<-.2){
  speed=.15/s_drive.slow();
}

else{
  speed=0;
}



  if(s_vison.camyaw()>10){
  turn=.3;
  }
  else if (s_vison.camyaw()<-10){
    turn=-.3;
  }
  else{
    turn=0;
  }
 
  
if(angal==222&&s_vison.camY()>.2){
  angal=90;
  speed=-.15/s_drive.slow();
}


if(angal==222&&s_vison.camY()<-.2){
  angal=90;
  speed=.15/s_drive.slow();
}

 if(angal!=222){
    turn=turn*2;
  }

SmartDashboard.putNumber("turn",turn);



s_drive.swerve(angal, speed, turn, angal);

}
else{
s_drive.swerve(222, 0, 0, 222);
  }





}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_drive.swerve(222, 0, 0, 222);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !button.get();
  }
}
