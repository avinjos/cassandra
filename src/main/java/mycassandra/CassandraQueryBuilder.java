package mycassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class CassandraQueryBuilder {

	public static void main(String[] args) {

		Cluster cluster;
		Session session;

		cluster = Cluster.builder().addContactPoint("127.0.0.1").withoutMetrics().build();

		session = cluster.connect("mastering");

		Statement allMovies = QueryBuilder.select().all().from("mastering", "movies");

		ResultSet results = session.execute(allMovies);

		for (Row row : results) {
			System.out.format(" %s  %s    %s  \n", row.getUUID("movie_id"), row.getString("title"),
					row.getInt("release_year"));
		}

	}

}
