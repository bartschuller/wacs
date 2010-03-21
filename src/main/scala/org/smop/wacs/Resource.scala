package org.smop.wacs

import javax.ws.rs.core.Context
import javax.servlet.http.HttpServletRequest

class Resource(
  @Context
  protected var request: HttpServletRequest
) {
  def this() = this(null)
}
