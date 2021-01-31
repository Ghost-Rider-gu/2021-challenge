package siendev.corp.apps.apache.commons.cli;

/**
 * @author Iurii Golubnichenko
 *
 * Imagine we work with logging service and to start it we need to pass next parameters:
 *  1. ip or hostName (which host we need to observe)
 *  2. updateInterval (a period of time when we need to update data in milliseconds)
 *  3. hasBackup (true or false if we need to do a backup of data)
 */
public class CommandLineParams {

    private String hostName;
    private Integer updateInterval;
    private Boolean hasBackup;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(Integer updateInterval) {
        this.updateInterval = updateInterval;
    }

    public Boolean getHasBackup() {
        return hasBackup;
    }

    public void setHasBackup(Boolean hasBackup) {
        this.hasBackup = hasBackup;
    }
}
