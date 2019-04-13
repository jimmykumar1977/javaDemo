package app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import app.service.OutputCreator;

@SpringBootApplication
public class JavaDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  ctx = SpringApplication.run(JavaDemoApplication.class, args);
		OutputCreator out = ctx.getBean(OutputCreator.class);
		try {
			String pathname = System.getProperty("outpath");
			if (StringUtils.isEmpty(pathname)) {
				System.out.println("blank folder .Exiting application");
				System.exit(0);
			}
			out.output(pathname);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}

}

