package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class CommandDesignPattern {
}

interface ElectronicDevice{
    public void on();
    public void off();
    public void volumeUp();
    public void volumeDown();
}

class Television implements ElectronicDevice{

    private int volume = 0;
    @Override
    public void on() {
        System.out.println("Tv On");
    }

    @Override
    public void off() {
        System.out.println("Tv Off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Tv volume up " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Tv volume down " + volume);
    }
}

class Radio implements ElectronicDevice{

    private int volume = 0;
    @Override
    public void on() {
        System.out.println("Radio On");
    }

    @Override
    public void off() {
        System.out.println("Radio Off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Radio Volume up " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Radio Volume down " + volume);
    }
}


interface Command {
    public void execute();
    public void undo();
}

class TurnTvOn implements Command{
    ElectronicDevice electronicDevice;

    public TurnTvOn(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.on();
    }

    @Override
    public void undo() {
        electronicDevice.off();
    }
}

class TurnTvOff implements Command{
    ElectronicDevice electronicDevice;

    public TurnTvOff(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.off();
    }

    @Override
    public void undo() {
        electronicDevice.on();
    }
}


class TvVolumeUp implements Command{
    ElectronicDevice electronicDevice;

    public TvVolumeUp(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.volumeUp();
    }

    @Override
    public void undo() {
        electronicDevice.volumeDown();
    }
}

class DeviceButton{
    Command command;

    public DeviceButton(Command command) {
        this.command = command;
    }

    public void press(){
        command.execute();
    }

    public void back(){
        command.undo();
    }

}

class TVRemote{
    public static ElectronicDevice getDevice(){
        return new Television();
    }
}

class CommandTest{
    public static void main(String[] args) {
        ElectronicDevice device = TVRemote.getDevice();
        TurnTvOn onCommand = new TurnTvOn(device);
        DeviceButton onPressed = new DeviceButton(onCommand);
        onPressed.press();

        TurnTvOff offCommand = new TurnTvOff(device);
        onPressed = new DeviceButton(offCommand);
        onPressed.press();

        TvVolumeUp volumeUpCommand = new TvVolumeUp(device);
        onPressed = new DeviceButton(volumeUpCommand);
        onPressed.press();
        onPressed.press();
        onPressed.press();

        Television tv1 = new Television();
        Radio radio1 = new Radio();
        List<ElectronicDevice> allDevices = new ArrayList<ElectronicDevice>();

        allDevices.add(tv1);
        allDevices.add(radio1);

        TurnItAllOn turnItAllOn = new TurnItAllOn(allDevices);
        onPressed = new DeviceButton(turnItAllOn);
        onPressed.press();
        onPressed.back();

        TurnItAllOff turnItAllOff = new TurnItAllOff(allDevices);
        onPressed = new DeviceButton(turnItAllOff);
        onPressed.press();
        onPressed.back();

    }
}

class TurnItAllOff implements Command{

    List<ElectronicDevice> theDevices;

    public TurnItAllOff(List<ElectronicDevice> theDevices) {
        this.theDevices = theDevices;
    }

    @Override
    public void execute() {
        for(ElectronicDevice device:theDevices){
            device.off();
        }
    }

    @Override
    public void undo() {
        for(ElectronicDevice device:theDevices){
            device.on();
        }
    }
}

class TurnItAllOn implements Command{

    List<ElectronicDevice> theDevices;

    public TurnItAllOn(List<ElectronicDevice> theDevices) {
        this.theDevices = theDevices;
    }

    @Override
    public void execute() {
        for(ElectronicDevice device:theDevices){
            device.on();
        }
    }

    @Override
    public void undo() {
        for(ElectronicDevice device:theDevices){
            device.off();
        }
    }
}