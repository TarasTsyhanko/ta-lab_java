package secondtask;

import firsttask.MainSum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void outputInfo(String info) {
        log.info("This is method reference. Param:" + info);
    }

    private static Command command1 = new CommandImpl();
    private static Command command2 = (info) -> log.info("This is lambda function. Param:" + info);

    private static Command command3 = new Command() {
        @Override
        public void execute(String str) {
            log.info("This is object of anonymous class. Param:" + str);
        }
    };
    private static Command command4 = Main::outputInfo;

    public static void main(String[] args) {
        Map<String, Command> commandsMap = new HashMap<>();
        commandsMap.put("class", command1);
        commandsMap.put("lambda", command2);
        commandsMap.put("anonymous", command3);
        commandsMap.put("reference", command4);

        String command = new Scanner(System.in).nextLine();
        String someArgument = new Scanner(System.in).nextLine();

        Command commandToExecute = commandsMap.get(command.trim());
        commandToExecute.execute(someArgument);
    }
}
