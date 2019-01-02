package mycassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Cassandra {

	public static void main(String[] args) {

		Cluster cluster;
		Session session;

		cluster = Cluster.builder()
						.addContactPoint("127.0.0.1")
						.withoutMetrics()
						.build();

		session = cluster.connect("mastering");
		System.out.println("creaated session " + session.getCluster().getClusterName());
//		session.execute("INSERT into movies(movie_id,title,release_year) VALUES (uuid(),'Blade Runner 2049',2018)");
		System.out.println("Done  , inserting .... !!");
		session.close();
	}

}
