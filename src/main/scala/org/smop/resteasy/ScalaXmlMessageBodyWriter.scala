package org.smop.resteasy

import javax.ws.rs.ext.{Provider, MessageBodyWriter}
import java.lang.{String, Class}
import javax.ws.rs.core.{MultivaluedMap, MediaType}
import java.lang.annotation.Annotation
import java.lang.reflect.Type
import xml.{XML, Node}
import java.io.{OutputStreamWriter, OutputStream}

@Provider
class ScalaXmlMessageBodyWriter extends MessageBodyWriter[Node] {
  def isWriteable(dataType: Class[_], typ: Type, annotations: Array[Annotation], mediaType: MediaType): Boolean =
    classOf[Node].isAssignableFrom(dataType)
  def getSize(node: Node, dataType: Class[_], typ: Type, annotations: Array[Annotation], mediaType: MediaType): Long = -1L
  def writeTo(node: Node, dataType: Class[_], typ: Type, annotations: Array[Annotation], mediaType: MediaType,
              mvm: MultivaluedMap[String, Object], os: OutputStream) {
    val writer = new OutputStreamWriter(os, "UTF-8")
    writer.write(node.toString)
    writer.close
  }
}
