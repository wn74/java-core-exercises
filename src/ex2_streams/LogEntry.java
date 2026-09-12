package ex2_streams;

import java.util.stream.Stream;

//String used for level instead of an enum for the purposes of this exercise 
public record LogEntry(String level, String service, String message) {
    
    public static LogEntry fromString(String rawData){

        String[] rawDataStrings = rawData.split("\\|");
        return new LogEntry(rawDataStrings[0],rawDataStrings[1],rawDataStrings[2]);
       
    }

    public static boolean isError(LogEntry entry){
        return "ERROR".equals(entry.level());
    }

    public static boolean isInfo(LogEntry entry){
        return "INFO".equals(entry.level());
    }

    public static boolean isWarn(LogEntry entry){
        return "WARN".equals(entry.level());
    }
}
