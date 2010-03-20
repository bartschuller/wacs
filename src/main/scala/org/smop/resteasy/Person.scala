package org.smop.resteasy

import javax.ws.rs.FormParam


class Person(
  @FormParam("name") var name: String,
  @FormParam("age") var age: Int
) {
  def this() = this(null, -1)
}
