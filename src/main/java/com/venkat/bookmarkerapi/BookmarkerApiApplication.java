package com.venkat.bookmarkerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*****
 *   URL : https://www.youtube.com/watch?v=UhEMh-HZIMY&list=PLuNxlOYbv61h66_QlcjCEkVAj6RdeplJJ&index=3
 * @author Venkatesh
 * 
 * http://10.160.21.60:8989/api/bookmark/one?page=3
 * 
 * http://10.160.21.60:8989/api/bookmark/two
 *
 *http://localhost:8989/h2-console/
 *
 *	VladMihalcea Blog :  https://vladmihalcea.com/  -  Hibernate 
	Thorben Janssen Blog: https://thorben-janssen.com/  - Hibernate & JPA
	Thorben Janssen YouTube Channel:    / thoughtsonjava  
 */
@SpringBootApplication
public class BookmarkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkerApiApplication.class, args);
	}

}
