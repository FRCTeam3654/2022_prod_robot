// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.RobotContainer;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SlidingClimbManualControlCommand extends CommandBase {
  /** Creates a new SlidingClimbManualControlCommand. */
  private boolean IsButtonPressed = false;
  //private boolean WasButtonNotPressed = false;
  public SlidingClimbManualControlCommand() {
    addRequirements(RobotContainer.slidingClimbHooks);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //RobotContainer.slidingClimbHooks.resetMotors();
    IsButtonPressed=false;
    //WasButtonNotPressed=false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if (RobotContainer.oi.manualSlidingClimbButton.get()) {
        if (IsButtonPressed == false){
          IsButtonPressed = true;
        }
      }
      SmartDashboard.putBoolean("ManualSlidingButtonClicked", IsButtonPressed);
      if (IsButtonPressed == true){
        //double joystickX = (RobotContainer.oi.driverStick.getX() * -1);
        //joystickX = handleDeadband(joystickX, RobotMap.joystickDeadBand);
        RobotContainer.slidingClimbHooks.driveClimbMotors(0);
      }

  }

  //public double handleDeadband(double val, double deadband){
    //return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
  //}
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}