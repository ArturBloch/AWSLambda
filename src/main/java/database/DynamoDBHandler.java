package database;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBHandler {

	private static DynamoDBHandler instance;
	public DynamoDBMapper dynamoDBMapper;

	private DynamoDBHandler() {
		dynamoDBMapper = new DynamoDBMapper(buildAmazonDynamoDB());
	}

	private AmazonDynamoDB buildAmazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
		                                  .withEndpointConfiguration(
			                                  new AwsClientBuilder.EndpointConfiguration("dynamodb.eu-central-1.amazonaws.com",
			                                                                             "eu-central-1"))
		                                  .withCredentials(new AWSStaticCredentialsProvider(
			                                  new BasicAWSCredentials(System.getenv("access_key"),System.getenv("secret_key"))) {
		                                  })
		                                  .build();
	}

	public static synchronized DynamoDBHandler getInstance() {
		if(instance == null){
			instance = new DynamoDBHandler();
		}
		return instance;
	}

}
