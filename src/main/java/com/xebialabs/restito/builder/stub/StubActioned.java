package com.xebialabs.restito.builder.stub;

import com.xebialabs.restito.semantics.Action;
import com.xebialabs.restito.semantics.Condition;
import com.xebialabs.restito.semantics.Stub;
import com.xebialabs.restito.server.StubServer;

public class StubActioned {

	private StubServer stubServer;

	private Condition condition;

	public StubActioned(StubServer stubServer, Condition condition) {
		this.stubServer = stubServer;
		this.condition = condition;
	}

	public StubExpected then(Action... actions) {
		Stub s = new Stub(condition, Action.composite(actions));
		stubServer.addStub(s);
		return new StubExpected(s);
	}
}
