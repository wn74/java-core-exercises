package ex2_streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class LogAnalyzer {


    //no static because Spring initializes components

    public void printLevelFilterQuery(List<LogEntry> messages, String level){

        List<LogEntry> entries = levelFilterQuery(messages, level);

        entries.forEach(message -> System.out.println("["+message.service()+"] "+message.message()));

    }

    public List<LogEntry> levelFilterQuery(List<LogEntry> messages, String level){

        return messages.stream().filter(entry -> entry.level().equals(level)).toList();

    }



    public void printServiceCountQuery(List<LogEntry> messages){

        Map<String, Long> countedServices = serviceCountQuery(messages);

        countedServices.forEach((service,count) -> System.out.println(service+": "+count));

    }

    public Map<String, Long> serviceCountQuery(List<LogEntry> messages){

        return messages.stream().collect(Collectors.groupingBy(LogEntry::service, Collectors.counting()));

    }



    public void printMessageFindFirstQuery(List<LogEntry> messages, String partialString){

        Optional<LogEntry> firstInstance = messageFindFirstQuery(messages, partialString);

        firstInstance.ifPresentOrElse(message -> System.out.println(message.message()), () -> System.out.println("Substring \""+ partialString+ "\" not found" ));

    }

    public Optional<LogEntry> messageFindFirstQuery(List<LogEntry> messages, String partialString){

        return messages.stream().filter(entry -> entry.message().toLowerCase().contains(partialString.toLowerCase())).findFirst();

    }





    public List<LogEntry> messageFilterQuery(List<LogEntry> messages, String partialString){

        return messages.stream().filter(entry -> entry.message().contains(partialString)).toList();

    }
    
    public List<LogEntry> serviceFilterQuery(List<LogEntry> messages, String service){

        return messages.stream().filter(entry -> entry.service().equals(service)).toList();

    }

}
