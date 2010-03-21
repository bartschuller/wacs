package org.smop.resteasy

import javax.servlet.http.HttpServletRequest

/**
 * Created by IntelliJ IDEA.
 * User: schuller
 * Date: Mar 18, 2010
 * Time: 10:45:15 PM
 * To change this template use File | Settings | File Templates.
 */

trait Tags {
  protected def request: HttpServletRequest

  def list(stuff: Seq[Any]) =
<ul>
{stuff.map(ent => <li>{ent}</li>)}
</ul>

  def href(relative: String) = request.getServletPath + relative
}
