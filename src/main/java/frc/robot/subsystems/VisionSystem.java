package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonTargetSortMode;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.MultiTargetPNPResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.proto.PhotonTrackedTargetProto;

import java.lang.Math;

public class VisionSystem extends SubsystemBase{
    private final PhotonCamera camera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
    double[] globalTagPosition = {};

    public double getAngle() {
        var result = camera.getLatestResult();
        double angle = 0;
        if(result.hasTargets()){
            PhotonTrackedTarget target = result.getBestTarget();
            if(target.getFiducialId() == 4 || target.getFiducialId() == 8){
                angle = target.getYaw();
            }
        }
        return angle;
    }
    public Double[] getLocalFieldPosition() {
        Double[] globalCameraPos = {};
        var result = camera.getLatestResult();
        if(result.getMultiTagResult().estimatedPose.isPresent == true){
            Transform3d fieldToCamera = result.getMultiTagResult().estimatedPose.best;
            globalCameraPos[0] = fieldToCamera.getX();
            globalCameraPos[1] = fieldToCamera.getY();
            globalCameraPos[2] = fieldToCamera.getZ();
        }
        return globalCameraPos;
    }
}

