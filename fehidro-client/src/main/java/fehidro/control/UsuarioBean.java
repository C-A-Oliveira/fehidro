package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fehidro.model.Usuario;
import fehidro.rest.client.UsuarioRESTClient;

@ManagedBean//(name="Usuario")
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private String consulta;
	
//	private Usuario usuario = new Usuario();

	
	
	public UsuarioBean() {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		usuarios = rest.findAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String paginaPrincipal() {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		usuarios = rest.findAll();
		return "/index";		
	}
	
	public String paginaUsuario() {
		this.usuario = new Usuario();
		return UsuarioRESTClient.REST_USUARIO_URL + "login";
	}
	
	public String paginaUsuario(Usuario usuario) {
		this.usuario = usuario;
		return UsuarioRESTClient.REST_USUARIO_URL + "login";
	}
	
	public String paginaUsuarioCadastro(){
		this.usuario = new Usuario();
		return UsuarioRESTClient.REST_USUARIO_URL + "cadastro";
	}
	
	public String paginaUsuarioCadastro(Usuario usuario){
		this.usuario = usuario;
		//this.usuario.setNome();
		return UsuarioRESTClient.REST_USUARIO_URL + "cadastro";
	}
	
	public String consultar() {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		if (consulta != null && !consulta.trim().isEmpty()) {
			
		}
		else {
			this.setUsuarios(rest.findAll());
		}
		return null;
	}
	
	public String gravar() {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		if (usuario.getId() == null) {
			rest.create(usuario);
			//usuario = new Usuario();			
		}
		else {
			usuario = rest.edit(usuario);
		}
		return null;		
	}
	
	
	public String excluir(Usuario u) {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		if (!rest.delete(u.getId())) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage("Não foi possível excluir o usuario " + u.getNome());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		else {
			usuarios.remove(u);
		}
		return null;
	}
}
