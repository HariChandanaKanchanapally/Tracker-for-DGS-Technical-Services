<%@ page contentType="image/jpeg"
import="java.awt.*,java.awt.image.*,
com.sun.image.codec.jpeg.*,java.util.*"
%>
<%
// Create image
int width=150, height=50;
BufferedImage image = new BufferedImage(width,
height, BufferedImage.TYPE_INT_RGB);
// Get drawing context
Graphics g = image.getGraphics();
// Fill background
g.setColor(Color.yellow);
g.fillRect(0, 0, 140, 50);

ServletOutputStream sos = response.getOutputStream();
JPEGImageEncoder encoder =
JPEGCodec.createJPEGEncoder(sos);
encoder.encode(image);
%>