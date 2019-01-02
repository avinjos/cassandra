package mycassandra;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

public class CassandraPreparedStatement {

	public void addMovies(Session session, int release_year, String title) {
		PreparedStatement insterStmt = session
				.prepare("Insert into movies (movie_id,release_year,title) VALUES (?,?,?)");
		BoundStatement bs = insterStmt.bind(UUID.randomUUID(), release_year, title);
		session.execute(bs);
	}

	public static void main(String[] args) {

		Cluster cluster;
		Session session;
		cluster = Cluster.builder().addContactPoint("127.0.0.1").withoutMetrics().build();

		session = cluster.connect("mastering");

		CassandraPreparedStatement cstatement = new CassandraPreparedStatement();
		cstatement.addMovies(session, 1986, "Big Trouble in Littele China");
	}
}
