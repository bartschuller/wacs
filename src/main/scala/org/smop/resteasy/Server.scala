package org.smop.resteasy

import javax.ws.rs._
import core._
import core.Response.{ResponseBuilder, Status}
import Tags._

@Path("/")
@Produces(Array("text/html; charset=utf-8"))
class Server {

  @GET
  @Path("/hello/{name}")
  def getEntry(@PathParam("name") name: String) = {
    val myList = List("Apples", "Pears", "Oranges")
    <html>
      <h1>Hi, {name}, you're worth beaucoup €</h1>
      {list(myList)}
    </html>
  }
}
