package BuilderPattern;

public class Robot implements RobotPlan{
    private String RobotHead;
    private String RobotTorso;
    private String RobotArms;
    private String RobotLegs;

    @Override
    public void setRobotHead(String head) {
        this.RobotHead = head;
    }

    @Override
    public void setRobotTorso(String torso) {
        this.RobotTorso = torso;
    }

    @Override
    public void setRobotArms(String arms) {
        this.RobotArms = arms;
    }

    @Override
    public void setRobotLegs(String legs) {
        this.RobotLegs = legs;
    }

    public String getRobotHead() {
        return RobotHead;
    }

    public String getRobotTorso() {
        return RobotTorso;
    }

    public String getRobotArms() {
        return RobotArms;
    }

    public String getRobotLegs() {
        return RobotLegs;
    }
}
