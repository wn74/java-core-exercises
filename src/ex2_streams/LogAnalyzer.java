package ex2_streams;
import java.util.List;
import java.util.stream.Stream;


public class LogAnalyzer {


    //no static because Spring initializes components
    public void filterQuery(List<LogEntry> messages, String level){

        messages.stream().filter(entry -> entry.level().equals(level)).forEach(message -> System.out.println("["+message.level()+"] "+message.message()));

    }

}
