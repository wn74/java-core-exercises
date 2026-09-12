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

    /**
     * Filters log entries by level
     * @param messages the list of log entries
     * @param level the looked for value
     * @return the list of log entries containing said level
     */
    public List<LogEntry> levelFilterQuery(List<LogEntry> messages, String level){

        return messages.stream().filter(entry -> entry.level().equals(level)).toList();

    }



    public void printServiceCountQuery(List<LogEntry> messages){

        Map<String, Long> countedServices = serviceCountQuery(messages);

        countedServices.forEach((service,count) -> System.out.println(service+": "+count));

    }

    /**
     * Counts all log entries of each separate service
     * @param messages the list of log entries
     * @return the map Service: amountOfEntries
     */
    public Map<String, Long> serviceCountQuery(List<LogEntry> messages){

        return messages.stream().collect(Collectors.groupingBy(LogEntry::service, Collectors.counting()));

    }



    public void printMessageFindFirstQuery(List<LogEntry> messages, String partialString){

        Optional<LogEntry> firstInstance = messageFindFirstQuery(messages, partialString);

        firstInstance.ifPresentOrElse(message -> System.out.println(message.message()), () -> System.out.println("Substring \""+ partialString+ "\" not found" ));

    }

    /**
     * Looks for the first log entry, whose message has partialString as a substring
     * @param messages the list of log entries
     * @param partialString the looked for substring
     * @return an Optional containing the first matching LogEntry, or an empty Optional if no match is found
     */
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
