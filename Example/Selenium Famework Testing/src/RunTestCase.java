import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import Framework.Harness;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class RunTestCase {

	public static void main(String[] args) throws IOException, RowsExceededException, BiffException, WriteException {
		// TODO Auto-generated method stub
		Harness oHarness = new Harness();
		oHarness.runTestCase();
		System.out.println("Done!!!");
	}

}
