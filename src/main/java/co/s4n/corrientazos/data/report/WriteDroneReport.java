package co.s4n.corrientazos.data.report;

import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.report.IWriteReport;
import com.jasongoodwin.monads.Try;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.List;

public class WriteDroneReport implements IWriteReport {

    private String outputPath;

    public WriteDroneReport(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void writeReport(String path, List<IDroneReport> reportList) {
        Try.ofFailable(() -> {
            Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            Velocity.init();
            /*  next, get the Template  */
            VelocityContext context = new VelocityContext();
            context.put("reportList", reportList);
            Writer writer = new FileWriter(Paths.get(outputPath, path).toFile());
            Velocity.mergeTemplate("drone_report.vm", "UTF-8", context, writer);
            writer.flush();
            writer.close();
            return context;
        });
    }

}
