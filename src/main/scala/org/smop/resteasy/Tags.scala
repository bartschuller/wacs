package org.smop.resteasy

/**
 * Created by IntelliJ IDEA.
 * User: schuller
 * Date: Mar 18, 2010
 * Time: 10:45:15 PM
 * To change this template use File | Settings | File Templates.
 */

object Tags {
  def list(stuff: Seq[Any]) =
<ul>
{stuff.map(ent => <li>{ent}</li>)}
</ul>
}
