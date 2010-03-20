package org.smop.resteasy

import javax.ws.rs._
import core._
import core.Response.{ResponseBuilder, Status}
import Tags._
import org.jboss.resteasy.annotations.Form

@Path("/")
@Produces(Array("text/html; charset=utf-8"))
class Server {

  @GET
  def index = {
    <html>
      {list(List(<a href="/hello/you">/hello/you</a>))}
      <form action="/showPerson" method="post">
        Name: <input name="name"/><br/>
        Age: <input name="age" /><br/>
        <input type="submit"/>
      </form>
    </html>
  }
  @GET
  @Path("/hello/{name}")
  def hello(@PathParam("name") name: String) = {
    val myList = List("Apples", "Pears", "Oranges")
    <html>
      <h1>Hi, {name}, you're worth beaucoup €</h1>
      {list(myList)}
    </html>
  }

  @POST
  @Path("/showPerson")
  def showPerson(@Form person: Person) = {
    <html>
      <p>Name: {person.name}</p>
      <p>Age: {person.age}</p>
    </html>
  }
}
