// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.IOConstants;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  CommandXboxController controller = new CommandXboxController(IOConstants.DRIVER_CONTROLLER_PORT_1);

  public RobotContainer() {
    configureBindings();

    driveSubsystem.setDefaultCommand(
      Commands.run(() -> driveSubsystem.arcadeDrive(-controller.getLeftY() * 0.5, controller.getRightX() * 0.5))
    );
  }
  

  private void configureBindings() {

    controller.leftBumper()
      .onTrue(Commands.run(() -> driveSubsystem.setToOutput(DriveConstants.MIN_OUTPUT)))
      .onFalse(Commands.run(() -> driveSubsystem.setToOutput(1)));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
