package mycassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraRead {

	public static void main(String[] args) {

		Cluster cluster;
		Session session;

		// connecting to Cassandra host running on local machine
		// With Cassandra driver 3.6 we need to add withoutMetrics , otherwise it results in compilation error
		cluster = Cluster.builder().addContactPoint("127.0.0.1").withoutMetrics().build();
		// Passing key space name , in this case it is mastering
		session = cluster.connect("mastering");
		// pass cql eqry to execute
		ResultSet results = session.execute("select * from movies");
		// Iterate over the resultset
		for (Row row : results) {
			System.out.format("%s %s %s \n ", row.getUUID("movie_id"), row.getString("title"),
					row.getInt("release_year"));

		}
		// close session
		session.close();
	}

}
