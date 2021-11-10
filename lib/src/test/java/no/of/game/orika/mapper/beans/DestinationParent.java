/*
 * (c) Copyright 2021 Marcin Nowakowski
 */
package no.of.game.orika.mapper.beans;

import java.util.List;

/**
 * @author <a href="game.of.no@gmail.com">Marcin Nowakowski</a>
 */
public class DestinationParent {
	private List<DestinationChild> destinationChildren;

	public void setDestinationChildren(List<DestinationChild> someOtherChildren) {
		this.destinationChildren = someOtherChildren;
	};

	public List<DestinationChild> retrieveDestinationChildren() {
		return destinationChildren;
	}
}
