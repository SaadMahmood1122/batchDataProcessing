package com.example.batch_processing;

import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PersonItemProcessor implements ItemProcessor<Person, Person>{
	/**
	 *PersonItemProcessor implements Spring Batch’s ItemProcessor interface. 
	 *This makes it easy to wire the code into a batch job that you will define later in this guide.
	 * According to the interface, you receive an incoming Person object,
	 * after which you transform it to an upper-cased Person. 
	 *
	 */
	
	
	
	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	@Override
	public Person process(final Person person) throws Exception {
		final String firstName = person.firstName().toUpperCase();
	    final String lastName = person.lastName().toUpperCase();

	    final Person transformedPerson = new Person(firstName, lastName);

	    log.info("Converting (" + person + ") into (" + transformedPerson + ")");

	    return transformedPerson;
	}

}
