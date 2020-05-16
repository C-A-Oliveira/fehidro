package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.Usuario;
import fehidro.rest.client.RESTClientInterface;

public class UsuarioRESTClient implements RESTClientInterface<Usuario>{
	private Response response; 

	@Override
	public List<Usuario> findAll() {
		Client client = ClientBuilder.newClient();

	    WebTarget webTarget = client.target(REST_WEBSERVICE_URL + REST_USUARIO_URL);

	    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    
	    this.response = invocationBuilder.get();
	    
	    List<Usuario> categorias = this.response.readEntity(new GenericType<List<Usuario>> () {});
	    
	    client.close();
	    
	    return categorias;
	}

	@Override
	public Usuario find(Long id) {
		this.response = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + id).
				request(MediaType.APPLICATION_JSON).
				get();
	    Usuario categoria = this.response.readEntity(Usuario.class);
	    
		return categoria;
	}

//	public Usuario findByCPF(String CPF) {
//		this.response = ClientBuilder.newClient().
//				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + "CPF/" + CPF).
//				request(MediaType.APPLICATION_JSON).
//				get();
//	    Usuario categoria = this.response.readEntity(Usuario.class);
//	    
//		return categoria;
//	}

	public List<Usuario> findByName(String nome) {
		this.response = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + "nome/" + nome).
				request(MediaType.APPLICATION_JSON).
				get();
	    List<Usuario> usuarios = this.response.readEntity(new GenericType<List<Usuario>> () {});	   
	    
		return usuarios;
	}

	@Override
	public Usuario create(Usuario obj) {
	    this.response = ClientBuilder.newClient().
	    		target(REST_WEBSERVICE_URL + REST_USUARIO_URL).
	    		queryParam("usuario", obj).
	    		request(MediaType.APPLICATION_JSON).
	    		post(Entity.entity(obj, MediaType.APPLICATION_JSON));
	    Usuario usuario = this.response.readEntity(Usuario.class);
		
		return usuario;
	}

	@Override
	public Usuario edit(Usuario obj) {
	    this.response = ClientBuilder.newClient().
	    		target(REST_WEBSERVICE_URL + REST_USUARIO_URL).
	    		queryParam("categoria", obj).
	    		request(MediaType.APPLICATION_JSON).
	    		put(Entity.entity(obj, MediaType.APPLICATION_JSON));

	    Usuario usuario = this.response.readEntity(Usuario.class);
	    
		return usuario;
	}

	@Override
	public boolean delete(Long id) {
		this.response = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + id).
				request(MediaType.APPLICATION_JSON).
				delete();

		return this.response.getStatus() == Response.Status.OK.getStatusCode();	
	}

}
