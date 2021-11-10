/*
 * (c) Copyright 2021 Marcin Nowakowski
 */
package no.of.game.orika.mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingException;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.property.RegexPropertyResolver;
import no.of.game.orika.mapper.beans.DestinationChild;
import no.of.game.orika.mapper.beans.DestinationParent;
import no.of.game.orika.mapper.beans.SourceChild;
import no.of.game.orika.mapper.beans.SourceParent;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author <a href="game.of.no@gmail.com">Marcin Nowakowski</a>
 */
class OrikaMapperTest {

	@Test
	void noGetterGenericTypeDestinationMapping() {
		// with separately mapped child class
		MapperFactory mapperFactoryWithSeparatelyMappedChildClass = new DefaultMapperFactory.Builder()
				.build();

		mapperFactoryWithSeparatelyMappedChildClass.classMap(SourceChild.class, DestinationChild.class)
				.field("sourceValue", "destinationValue").register();
		mapperFactoryWithSeparatelyMappedChildClass.classMap(SourceParent.class, DestinationParent.class)
				.field("sourceChildren", "destinationChildren").register();

		BoundMapperFacade<SourceParent, DestinationParent> mapperWithSeparatelyMappedChildClass =
				mapperFactoryWithSeparatelyMappedChildClass.getMapperFacade(SourceParent.class, DestinationParent.class);

		SourceChild sourceChild = new SourceChild("original source value");
		SourceParent sourceParent = new SourceParent(List.of(sourceChild));
		DestinationParent destinationParent = mapperWithSeparatelyMappedChildClass.map(sourceParent);

		assertEquals(sourceParent.getSourceChildren().get(0).getSourceValue(),
				destinationParent.retrieveDestinationChildren().get(0).retrieveDestinationValue());

		// with mapping through collection access expression
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
				.build();
		Exception mappingException = assertThrows(Exception.class, () ->
				mapperFactory.classMap(SourceParent.class, DestinationParent.class)
						.field("sourceChildren{sourceValue}", "destinationChildren{destinationValue}").register()
		);
		assertTrue(mappingException.getMessage().contains(
				"ClassMapBuilder.map(SourceParent, DestinationParent)" +
						".field('sourceChildren{sourceValue}', 'destinationChildren{destinationValue}'): " +
						"Error: destinationValue does not belong to Object"));
	}
}
