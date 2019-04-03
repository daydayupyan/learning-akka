package com.lightbend.akka.first;

import java.util.HashMap;
import java.util.Map;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class AkkademyDb extends AbstractActor {
	protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
	protected final Map<String, Object> map = new HashMap<>();
	
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return super.receiveBuilder().
                match(SetRequest.class, message -> {
                    log.info("Received Set request: {}", message);
                    map.put(message.getKey(), message.getValue());
                }).
                matchAny(o -> log.info("received unknown message: {}", o))
                .build();
	}

}
