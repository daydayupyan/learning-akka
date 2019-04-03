package com.lightbend.akka.first;

import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;

public class AkkademyDbTest {
	ActorSystem system = ActorSystem.create();
	
	@Test
	public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
		TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
		actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
		AkkademyDb akkademyDb = actorRef.underlyingActor();
		System.out.println(akkademyDb.map.toString());
	}
}
