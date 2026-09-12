package ex2_streams;

import java.util.List;
import java.util.stream.Stream;

//=========================Log processing========================= 
//--Log Entry:
//  [x] Create from string of struncture "LEVEL|SERVICE|MESSAGE"
//  Queries:    
//      [x]Filter by level    
//      [x]Count logs by service
//      []Search first entry containing a specific word (using Optional)


public class Main {
    
    

    public static void main(String[] args) {

    List<String> rawLogs = List.of(
        "INFO|auth-service|User admin logged in successfully",
        "ERROR|payment-service|Database connection timed out",
        "WARN|order-service|Stock low for item ID 4912",
        "INFO|order-service|Order #1001 placed successfully",
        "ERROR|auth-service|Invalid token signature",
        "INFO|auth-service|Token refreshed for user 102",
        "WARN|order-service|Payment confirmation pending for order #1002",
        "INFO|order-service|Order #1002 status updated to PROCESSING",
        "INFO|payment-service|Payment processed successfully for order #1001"
        );
      
    List<LogEntry> entryStream = rawLogs.stream()
                                        .map(rawString -> LogEntry.fromString(rawString))
                                        .toList();

    LogAnalyzer analyzer = new LogAnalyzer();

    analyzer.printLevelFilterQuery(entryStream, "INFO");
    analyzer.printServiceCountQuery(entryStream);

    }
    

    

}
