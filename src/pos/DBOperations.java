
package pos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class DBOperations {
	XStream	xstream;

	public DBOperations() {
		xstream = new XStream(new StaxDriver());
		xstream.alias("Customer", Customer.class);
		xstream.alias("User", User.class);
		xstream.alias("CustomerRecords", CustomerRecords.class);

	}

	public void toXML(Object o, File file) {
		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			xstream.toXML(o, writer);
		} catch (IOException e) {

		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
			}
		}

	}

	public Object fromXML(File file) {
		return xstream.fromXML(file);
	}
}
