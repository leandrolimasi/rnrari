package br.com.incode.tour.model.service;


import com.powerlogic.jcompany.model.test.PlcAbstractArquillianTestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;


public abstract class AppAbstractArquillianTestCase extends PlcAbstractArquillianTestCase {
	

	@Deployment
	public static WebArchive createTestArchive() {
		WebArchive j = ShrinkWrap.create(WebArchive.class);
		complementTestArchive(j);

		j.addAsResource("META-INF/persistence.xml", ArchivePaths.create("META-INF/persistence.xml"));
		j.addAsResource("META-INF/beans.xml", ArchivePaths.create("META-INF/beans.xml"));
		j.addAsResource("PlcMessages_pt_BR.properties", ArchivePaths.create("PlcMessages_pt_BR.properties"));
		j.addAsResource("AppMessages_pt_BR.properties", ArchivePaths.create("AppMessages_pt_BR.properties"));
		j.setWebXML("META-INF/web.xml");		

		return j;
	}
		
}


