package manager;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
//Tem ser faces bean as duas importação
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.spi.SessionImplementor;

import com.mysql.jdbc.Connection;

import entity.Animal;
import net.sf.jasperreports.engine.JasperRunManager;
import persistence.AnimalDao;
import persistence.HibernateUtil;

@ManagedBean(name = "mb")
@ViewScoped
@RequestScoped
public class ManagerBean {

	private Animal animal;
	private List<Animal> animais;

	public ManagerBean() {
		this.animal = new Animal();
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Animal> getAnimais() {
		if(this.animais == null){
			this.animais = new AnimalDao().findAll();	
		}
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	// Metodo para rodar relatorio
	public void relatorio() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			InputStream arquivo = (InputStream) fc.getExternalContext().getResourceAsStream("/relatorioAnimal.jasper");
			SessionImplementor sim = (SessionImplementor) HibernateUtil.getSessionFactory().openSession();
			// Hibernate pra jdbc
			Connection con = (Connection) sim.connection();
			// Tela com dados
			byte pdf[] = JasperRunManager.runReportToPdf(arquivo, null, con);
			HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
			ServletOutputStream out = response.getOutputStream();
			out.write(pdf);
			out.flush();
			out.close();
			fc.responseComplete();// Atualizar na tela
		} catch (Exception ex) {
			System.out.println("Error:" + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void gravar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			new AnimalDao().create(this.animal);
			this.animal = new Animal();
			fc.addMessage(null, new FacesMessage("Dados gravados com sucesso"));
		}catch (Exception ex) {
			ex.printStackTrace();
			fc.addMessage(null, new FacesMessage("Error:" + ex.getMessage()));
			// TODO: handle exception
		}
	}
		public void editar(){
			FacesContext fc = FacesContext.getCurrentInstance();
			try{
				new AnimalDao().update(animal);
				this.animal = new Animal();
				fc.addMessage(null, new FacesMessage("Dados alterados com sucesso"));
			}catch (Exception ex) {
				ex.printStackTrace();
				fc.addMessage(null, new FacesMessage("Error:" + ex.getMessage()));
			}
	}
		
		
		public void excluir() {
			FacesContext fc = FacesContext.getCurrentInstance();
			try {
				new AnimalDao().delete(this.animal);
				this.animais = new AnimalDao().findAll();
				fc.addMessage(null, new FacesMessage("Registro Excluido"));
			} catch (Exception ex) {
				fc.addMessage(null, new FacesMessage("Error ..." + ex.getMessage()));
			}
		}
}
