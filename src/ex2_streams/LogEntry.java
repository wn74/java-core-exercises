package ex2_streams;

//String used for level instead of an enum for the purposes of this exercise 
public record LogEntry(String level, String service, String message) {
    
    public static LogEntry fromString(String rawData){

        String[] rawDataStrings = rawData.split("\\|");
        return new LogEntry(rawDataStrings[0],rawDataStrings[1],rawDataStrings[2]);
       
    }

    public  boolean isError(){
        return "ERROR".equals(this.level());
    }

    public  boolean isInfo(){
        return "INFO".equals(this.level());
    }

    public  boolean isWarn(){
        return "WARN".equals(this.level());
    }
}
