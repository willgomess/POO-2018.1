
public class ControlaLogin {
	
		private Repositorio<User> usuarios;
		private User user;
		
		public ControlaLogin(Repositorio<User> usuarios) {
			this.usuarios = usuarios;
			user = null;
		}
		
		public void Login(String usuario, String password) {
			if(user != null)
				throw new RuntimeException("fail: Ja existe alguem logado");
			if(!usuarios.get(usuario).matchPassword(password)) 
			   throw new RuntimeException("fail: senha invalida ou pessoa nao encontrada");
			this.user = usuarios.get(usuario);
		}

		public void Logout() {
			if(user == null)
			    throw new RuntimeException("fail: n�o est� ninguem logado");
			System.out.println("ok");
			this.user = null;
		}
		
		public User getUser() {
			if(user == null)
				throw new RuntimeException("fail: n�o est� ninguem logado");
			return user;
		}
		
	
}
