package by.tms.entity;

import java.util.List;

public class Filter {
    private List<String> producers;
    private List<String> releaseDates;
    private List<String> screenSizes;
    private List<String> colors;
    private List<String> operatingSystems;
    private List<String> batteryCapacities;



    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    public List<String> getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(List<String> releaseDates) {
        this.releaseDates = releaseDates;
    }

    public List<String> getScreenSizes() {
        return screenSizes;
    }

    public void setScreenSizes(List<String> screenSizes) {
        this.screenSizes = screenSizes;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public List<String> getBatteryCapacities() {
        return batteryCapacities;
    }

    public void setBatteryCapacities(List<String> batteryCapacities) {
        this.batteryCapacities = batteryCapacities;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "producers=" + producers +
                ", releaseDates=" + releaseDates +
                ", screenSizes=" + screenSizes +
                ", colors=" + colors +
                ", operatingSystems=" + operatingSystems +
                ", batteryCapacities=" + batteryCapacities +
                '}';
    }
}
