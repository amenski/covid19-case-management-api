package et.covid19.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
//@Import(value={EthAuthUtilLibraryConfigurator.class})
public class Application extends SpringBootServletInitializer {

    private static final String API_VERSION = "API_VERSION";
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        String implementationVersion="";
        try {
            InputStream manifestInput = servletContext.getResourceAsStream("META-INF/MANIFEST.MF");
            if(manifestInput != null){
                Manifest manifest = new Manifest(manifestInput);
                implementationVersion = (String) manifest.getMainAttributes().get(Attributes.Name.IMPLEMENTATION_VERSION);
                System.setProperty(Application.API_VERSION, implementationVersion);
            }
        }catch(IOException e) {
            logger.error("Unable to read manifest file.");
        }
        super.onStartup(servletContext);
    }
}
