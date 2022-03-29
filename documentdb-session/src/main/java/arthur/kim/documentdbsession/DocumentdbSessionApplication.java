package arthur.kim.documentdbsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocumentdbSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentdbSessionApplication.class, args);
		
		String template = "mongodb://%s:%s@%s/sample-database?replicaSet=rs0&readpreference=%s";
		String username = "<sample-user>";
		String password = "<password>";
		String clusterEndpoint = "sample-cluster.node.us-east-1.docdb.amazonaws.com:27017";
		String readPreference = "secondaryPreferred";
		String connectionString = String.format(template, username, password, clusterEndpoint, readPreference);

		MongoClientURI clientURI = new MongoClientURI(connectionString);
		MongoClient mongoClient = new MongoClient(clientURI);

		MongoDatabase testDB = mongoClient.getDatabase("sample-database");
		MongoCollection<Document> numbersCollection = testDB.getCollection("sample-collection");

		Document doc = new Document("name", "pi").append("value", 3.14159);
		numbersCollection.insertOne(doc);

		MongoCursor<Document> cursor = numbersCollection.find().iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}

	}
}
