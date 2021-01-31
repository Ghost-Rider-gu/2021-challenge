package siendev.corp.apps.apache.commons.cli;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * @author Iurii Golubnichenko
 *
 * Just an example (logging service).
 */
public class LoggingServiceStarter {

    private final CommandLineParams params;
    private final Options options;

    public LoggingServiceStarter() {
        this.params = new CommandLineParams();
        this.options = new Options();

        options.addOption("help", "help", false, "Show help");
        options.addOption("backup", "backup", true, "Do we need a backup");
        options.addOption("host", "host", true, "Host name or ip");
        options.addOption("update", "update", true, "Update interval in milliseconds");
    }

    /**
     * Prepare to start our logging service.
     *
     * @param arguments {@link String[]}
     */
    public void prepareToStart(String[] arguments) {
        if (arguments.length == 0) {
            this.showHelp();
        }

        CommandLineParser parser = new DefaultParser();

        try {
            Option[] parsedOptions = parser.parse(options, arguments).getOptions();
            for (Option option: parsedOptions) {
                switch (option.getOpt()) {
                    case "help":
                        showHelp();
                        break;
                    case "backup":
                        this.params.setHasBackup(Boolean.valueOf(option.getValue()));
                        break;
                    case "host":
                        this.params.setHostName(option.getValue());
                        break;
                    case "update":
                        this.params.setUpdateInterval(Integer.parseInt(option.getValue()));
                        break;
                    default: throw new ParseException("Cannot recognize a parameter ...");
                }
            }
            LoggingService loggingService = new LoggingService(this.params);
            loggingService.launch();
        } catch (ParseException ex) {
            System.out.println("Failed to parse command line: " + ex.getMessage());
            System.exit(0);
        }
    }

    private void showHelp() {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("HELP", options);

        System.exit(0);
    }
}
