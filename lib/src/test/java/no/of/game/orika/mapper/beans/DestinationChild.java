/*
 * (c) Copyright 2021 Marcin Nowakowski
 */
package no.of.game.orika.mapper.beans;

import java.util.List;

/**
 * @author <a href="game.of.no@gmail.com">Marcin Nowakowski</a>
 */
public class DestinationChild {
	private String destinationValue;

	public void setDestinationValue(String destinationValue) {
		this.destinationValue = destinationValue;
	}

	public String retrieveDestinationValue() {
		return destinationValue;
	}
}
