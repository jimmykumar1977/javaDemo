package app.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

@Component
public class OutputCreator {

	public  void output(String args) throws IOException {
		System.out.println("==> path "+args);
		File f = Paths.get(args).toFile();
		if (!f.exists()) {
			System.out.println("creating folder "+args);
			f.mkdirs();
		}
		File nf = Paths.get(args, "out.txt").toFile();
		if (nf.exists())
		{
			nf.createNewFile();
		}
		BufferedWriter br = new BufferedWriter(new FileWriter(nf));
		for(int i=0;i<100;i++) {
			br.write("1234567");
			br.newLine();
		}
		br.close();

	}

}
