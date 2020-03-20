package org.test.aws;

import java.util.List;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        listTables();
    }


    static void listTables(){
        Region region = Region.US_EAST_2;
        DynamoDbClient ddb = DynamoDbClient.builder().region(region).build();
        ListTablesRequest req = ListTablesRequest.builder().build();
        ListTablesResponse resp = ddb.listTables(req);

        List<String> tableNames = resp.tableNames();
        System.out.println("tables:");
        for(String table : tableNames){
            System.out.println(table);
        }

        ddb.close();

    }



}
