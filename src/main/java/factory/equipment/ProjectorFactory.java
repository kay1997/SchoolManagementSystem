package factory.equipment;

import domain.equipment.Projector;

public class ProjectorFactory {

    public static Projector getProjector(String projectorCode, String projectorName) {
        return new Projector.Builder().projectorCode(projectorCode).projectorName(projectorName).build();
    }
}
