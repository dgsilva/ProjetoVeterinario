package config;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Main {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration().
				configure("config/mysql_hibernate.cfg.xml");
		new SchemaExport(cfg).create(true,true);
		//Se não tive o driver do mysql não irá rodar o projeto.
		System.out.println("Foi conectado com sucesso");
	}

}
