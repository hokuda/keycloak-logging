package com.example.keycloak;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import java.util.logging.Logger;
import java.util.logging.Level;

@Path("/logging")
public class LoggingResource {

  private static Level getLogLevel(Logger logger) throws Exception {
    for (Logger current = logger; current != null;) {
      Level level = current.getLevel();
      if (level != null)
        return level;
      current = current.getParent();
    }
    throw new Exception("root logger undefined");
  }

  @GET
  @Path("/{logger}")
  @Produces("text/plain")
  public String logger(@PathParam("logger") String loggerName, @QueryParam("level") String level)
      throws Exception {
    // get the logger instance
    Logger logger = Logger.getLogger(loggerName);

    // change the log-level if requested
    if (level != null && level.length() > 0)
      logger.setLevel(Level.parse(level));

    // return the current log-level
    return getLogLevel(logger).toString() + "\n";
  }
}
