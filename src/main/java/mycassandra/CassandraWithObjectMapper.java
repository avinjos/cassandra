package mycassandra;

import java.util.UUID;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.domain.movies.Movie;

public class CassandraWithObjectMapper {

	public static void main(String[] args) {
		Session session;
		Cluster cluster;

		cluster = Cluster.builder().addContactPoint("127.0.0.1").withoutMetrics().build();
		session = cluster.connect("mastering");
		MappingManager manager = new MappingManager(session);
		Mapper<Movie> mapper = manager.mapper(Movie.class);
		// Create a new movie object to add
		Movie movieToAdd = new Movie(UUID.randomUUID(), 2018, "The Nun");
		// Save Movie Object with Writing query
		mapper.save(movieToAdd);
		// Retrieve movie Object using primary key, Important to note get method needs all parts of primary key 
		Movie movie = mapper.get(UUID.fromString("734e8f72-6032-495c-8ce4-960572c6ebc8"));
		System.out.println("Movie " + movie);

	}

}
