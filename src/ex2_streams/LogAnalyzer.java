package ex2_streams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LogAnalyzer {


    //no static because Spring initializes components
    public List<LogEntry> levelFilterQuery(List<LogEntry> messages, String level){

        return messages.stream().filter(entry -> entry.level().equals(level)).toList();

    }
    public List<LogEntry> serviceFilterQuery(List<LogEntry> messages, String service){

        return messages.stream().filter(entry -> entry.service().equals(service)).toList();

    }
    public List<LogEntry> messageFilterQuery(List<LogEntry> messages, String message){

        return messages.stream().filter(entry -> entry.message().equals(message)).toList();

    }

    public void printLevelFilterQuery(List<LogEntry> messages, String level){

        List<LogEntry> entries = levelFilterQuery(messages, level);

        entries.forEach(message -> System.out.println("["+message.service()+"] "+message.message()));

    }


    public Map<String, Long> serviceCountQuery(List<LogEntry> messages){

       
        return messages.stream().collect(Collectors.groupingBy(LogEntry::service, Collectors.counting()));

        
    }

    public void printServiceCountQuery(List<LogEntry> messages){
        Map<String, Long> countedServices = serviceCountQuery(messages);

        countedServices.forEach((service,count) -> System.out.println(service+": "+count));

    }

}
