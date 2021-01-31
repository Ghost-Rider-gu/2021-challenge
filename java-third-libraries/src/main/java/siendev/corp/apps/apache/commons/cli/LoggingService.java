package siendev.corp.apps.apache.commons.cli;

/**
 * @author Iurii Golubnichenko
 *
 * Just an example (logging service).
 */
public class LoggingService {

    private final CommandLineParams params;

    public LoggingService(CommandLineParams params) {
        this.params = new CommandLineParams();

        this.params.setHostName(params.getHostName());
        this.params.setUpdateInterval(params.getUpdateInterval());
        this.params.setHasBackup(params.getHasBackup());
    }

    public void launch() {
        System.out.println("===============================================");
        System.out.println(String.format("Host name is: [%s] \t update interval: [%d] \t there is a backup: [%s]",
                this.params.getHostName(),
                this.params.getUpdateInterval(),
                this.params.getHasBackup()));
        System.out.println("===============================================");
    }
}
