/*
 * (c) Copyright 2021 Marcin Nowakowski
 */
package no.of.game.orika.mapper.beans;

/**
 * @author <a href="game.of.no@gmail.com">Marcin Nowakowski</a>
 */

import java.util.List;
public class SourceParent {
 	private List<SourceChild> sourceChildren;

 	public SourceParent(List<SourceChild> sourceChildren) {
	    this.sourceChildren = sourceChildren;
    }

 	public List<SourceChild> getSourceChildren() {
 		return sourceChildren;
    }
}
